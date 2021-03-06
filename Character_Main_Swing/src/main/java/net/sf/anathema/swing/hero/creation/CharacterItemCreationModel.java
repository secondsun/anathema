package net.sf.anathema.swing.hero.creation;

import com.google.common.base.Objects;
import net.sf.anathema.character.main.CharacterStatisticsConfiguration;
import net.sf.anathema.character.main.template.HeroTemplate;
import net.sf.anathema.character.main.template.ITemplateRegistry;
import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.character.main.type.CharacterTypes;
import net.sf.anathema.character.main.view.repository.ITemplateTypeAggregation;
import net.sf.anathema.hero.framework.HeroEnvironment;
import net.sf.anathema.lib.collection.MultiEntryMap;
import net.sf.anathema.lib.control.ChangeListener;
import org.jmock.example.announcer.Announcer;

import java.util.ArrayList;
import java.util.List;

public class CharacterItemCreationModel implements ICharacterItemCreationModel {

  private final CharacterTypes characterTypes;
  private CharacterType selectedType;
  private final Announcer<ChangeListener> control = Announcer.to(ChangeListener.class);
  private ITemplateTypeAggregation selectedTemplate;
  private final MultiEntryMap<CharacterType, ITemplateTypeAggregation> aggregationsByType = new MultiEntryMap<>();
  private final CharacterStatisticsConfiguration configuration;
  private final HeroEnvironment generics;
  private final CharacterType[] types;

  public CharacterItemCreationModel(HeroEnvironment generics, CharacterStatisticsConfiguration configuration) {
    this.generics = generics;
    this.configuration = configuration;
    this.characterTypes = generics.getCharacterTypes();
    this.types = collectCharacterTypes(generics.getTemplateRegistry());
    aggregateTemplates();
    setCharacterType(characterTypes.findAll()[0]);
  }

  private CharacterType[] collectCharacterTypes(ITemplateRegistry registry) {
    List<CharacterType> availableTypes = new ArrayList<>();
    for (CharacterType type : characterTypes.findAll()) {
      if (registry.getAllSupportedTemplates(type).length > 0) {
        availableTypes.add(type);
      }
    }
    return availableTypes.toArray(new CharacterType[availableTypes.size()]);
  }

  private void aggregateTemplates() {
    TemplateTypeAggregator aggregator = new TemplateTypeAggregator(generics.getTemplateRegistry());
    for (CharacterType type : characterTypes.findAll()) {
      ITemplateTypeAggregation[] aggregations = aggregator.aggregateTemplates(type);
      if (aggregations.length == 0) {
        continue;
      }
      aggregationsByType.add(type, aggregations);
    }
  }

  @Override
  public boolean isSelectionComplete() {
    return configuration.getTemplate() != null;
  }

  @Override
  public CharacterType[] getAvailableCharacterTypes() {
    return types;
  }

  @Override
  public void setCharacterType(CharacterType type) {
    if (Objects.equal(selectedType, type)) {
      return;
    }
    this.selectedType = type;
    setTemplateToDefault();
    control.announce().changeOccurred();
  }

  private void setTemplateToDefault() {
    if (getAvailableTemplates().length == 0) {
      setSelectedTemplate(null);
    } else {
      HeroTemplate defaultTemplate = generics.getTemplateRegistry().getDefaultTemplate(selectedType);
      for (ITemplateTypeAggregation aggregation : aggregationsByType.get(selectedType)) {
        if (aggregation.contains(defaultTemplate)) {
          setSelectedTemplate(aggregation);
          return;
        }
      }
      throw new IllegalStateException("Template not contained in aggregations.");
    }
  }

  @Override
  public ITemplateTypeAggregation[] getAvailableTemplates() {
    List<ITemplateTypeAggregation> list = aggregationsByType.get(selectedType);
    List<ITemplateTypeAggregation> copyList = new ArrayList<>(list);
    return copyList.toArray(new ITemplateTypeAggregation[copyList.size()]);
  }

  @Override
  public void setSelectedTemplate(ITemplateTypeAggregation newValue) {
    if (selectedTemplate == newValue) {
      return;
    }
    this.selectedTemplate = newValue;
    if (selectedTemplate == null) {
      configuration.setTemplate(null);
    } else {
      setEditionDependentTemplate();
    }
    control.announce().changeOccurred();
  }

  private void setEditionDependentTemplate() {
    configuration.setTemplate(generics.getTemplateRegistry().getTemplate(selectedTemplate.getTemplateType()));
  }

  @Override
  public ITemplateTypeAggregation getSelectedTemplate() {
    return selectedTemplate;
  }

  @Override
  public void addListener(ChangeListener listener) {
    control.addListener(listener);
  }
}