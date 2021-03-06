package net.sf.anathema.hero.spells.display.presenter;

import net.sf.anathema.character.main.magic.description.MagicDescriptionProvider;
import net.sf.anathema.hero.charms.display.presenter.CharmDescriptionProviderExtractor;
import net.sf.anathema.character.main.view.SectionView;
import net.sf.anathema.framework.IApplicationModel;
import net.sf.anathema.hero.display.presenter.HeroModelInitializer;
import net.sf.anathema.hero.experience.ExperienceModel;
import net.sf.anathema.hero.experience.ExperienceModelFetcher;
import net.sf.anathema.hero.model.Hero;
import net.sf.anathema.hero.spells.model.CircleModel;
import net.sf.anathema.hero.spells.model.SpellsModel;
import net.sf.anathema.hero.spells.model.SpellsModelFetcher;
import net.sf.anathema.lib.resources.Resources;

public class SpellInitializer implements HeroModelInitializer {
  private IApplicationModel applicationModel;
  private final String titleKey;
  private final CircleModel circleModel;

  public SpellInitializer(IApplicationModel applicationModel, String titleKey, CircleModel circleModel) {
    this.applicationModel = applicationModel;
    this.titleKey = titleKey;
    this.circleModel = circleModel;
  }

  @Override
  public void initialize(SectionView sectionView, Hero hero, Resources resources) {
    String header = resources.getString(titleKey);
    SpellView view = sectionView.addView(header, SpellView.class, hero.getTemplate().getTemplateType().getCharacterType());
    MagicDescriptionProvider magicDescriptionProvider = CharmDescriptionProviderExtractor.CreateFor(applicationModel, resources);
    ExperienceModel experienceModel = ExperienceModelFetcher.fetch(hero);
    SpellsModel spellsModel = SpellsModelFetcher.fetch(hero);
    new SpellPresenter(circleModel, resources, view, magicDescriptionProvider, experienceModel, spellsModel).initPresentation();
  }
}