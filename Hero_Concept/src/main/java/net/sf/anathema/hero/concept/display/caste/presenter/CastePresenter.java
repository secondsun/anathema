package net.sf.anathema.hero.concept.display.caste.presenter;

import net.sf.anathema.character.main.template.HeroTemplate;
import net.sf.anathema.hero.concept.CasteSelection;
import net.sf.anathema.hero.concept.CasteType;
import net.sf.anathema.hero.concept.HeroConceptFetcher;
import net.sf.anathema.hero.experience.ExperienceModel;
import net.sf.anathema.hero.experience.ExperienceModelFetcher;
import net.sf.anathema.hero.model.Hero;
import net.sf.anathema.lib.control.ChangeListener;
import net.sf.anathema.lib.control.ObjectValueListener;
import net.sf.anathema.lib.gui.AgnosticUIConfiguration;
import net.sf.anathema.lib.gui.selection.ObjectSelectionView;
import net.sf.anathema.lib.resources.Resources;

public class CastePresenter {

  private final CasteView view;
  private final Hero hero;
  private final Resources resources;

  public CastePresenter(Hero hero, CasteView view, Resources resources) {
    this.hero = hero;
    this.view = view;
    this.resources = resources;
  }

  public void initPresentation() {
    HeroTemplate template = hero.getTemplate();
    String casteLabelResourceKey = template.getPresentationProperties().getCasteLabelResource();
    CasteType[] casteTypes = HeroConceptFetcher.fetch(hero).getCasteCollection().getAllCasteTypes(hero.getTemplate().getTemplateType());
    AgnosticUIConfiguration<CasteType> casteUi = new AgnosticCasteUi(resources, template.getPresentationProperties());
    final ObjectSelectionView<CasteType> casteView = view.addObjectSelectionView(resources.getString(casteLabelResourceKey), casteUi);
    casteView.setObjects(casteTypes);
    final CasteSelection caste = HeroConceptFetcher.fetch(hero).getCaste();
    if (caste.isNotSelected()) {
      caste.setType(casteTypes[0]);
    }
    casteView.setSelectedObject(caste.getType());
    casteView.addObjectSelectionChangedListener(new ObjectValueListener<CasteType>() {
      @Override
      public void valueChanged(CasteType newValue) {
        caste.setType(newValue);
      }
    });
    caste.addChangeListener(new ChangeListener() {
      @Override
      public void changeOccurred() {
        casteView.setSelectedObject(caste.getType());
      }
    });
    initExperienceListening(casteView);
  }

  private void initExperienceListening(final ObjectSelectionView<CasteType> casteView) {
    final ExperienceModel experienceModel = ExperienceModelFetcher.fetch(hero);
    experienceModel.addStateChangeListener(new ChangeListener() {
      @Override
      public void changeOccurred() {
        casteView.setEnabled(!experienceModel.isExperienced());
      }
    });
    casteView.setEnabled(!experienceModel.isExperienced());
  }
}