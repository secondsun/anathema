package net.sf.anathema.hero.advance.overview.presenter;

import net.sf.anathema.character.main.library.overview.OverviewCategory;
import net.sf.anathema.character.main.view.labelledvalue.IValueView;
import net.sf.anathema.character.main.view.labelledvalue.LabelledAllotmentView;
import net.sf.anathema.hero.advance.experience.ExperiencePointConfigurationListener;
import net.sf.anathema.hero.advance.experience.ExperiencePointManagement;
import net.sf.anathema.hero.advance.overview.view.CategorizedOverview;
import net.sf.anathema.hero.experience.ExperienceModelFetcher;
import net.sf.anathema.hero.model.Hero;
import net.sf.anathema.hero.model.change.ChangeFlavor;
import net.sf.anathema.hero.model.change.FlavoredChangeListener;
import net.sf.anathema.hero.points.overview.IValueModel;
import net.sf.anathema.lib.control.legality.LegalityColorProvider;
import net.sf.anathema.lib.gui.Presenter;
import net.sf.anathema.lib.resources.Resources;

import java.util.ArrayList;
import java.util.List;

public class ExperiencedOverviewPresenter implements Presenter {

  private final ExperiencePointManagement management;
  private final CategorizedOverview view;
  private final Hero hero;
  private final Resources resources;
  private final List<IOverviewSubPresenter> presenters = new ArrayList<>();

  private LabelledAllotmentView totalView;

  public ExperiencedOverviewPresenter(Resources resources, final Hero hero, CategorizedOverview overview,
                                      ExperiencePointManagement experiencePoints) {
    this.resources = resources;
    this.hero = hero;
    hero.getChangeAnnouncer().addListener(new FlavoredChangeListener() {
      @Override
      public void changeOccurred(ChangeFlavor flavor) {
        if (ExperienceModelFetcher.fetch(hero).isExperienced()) {
          calculateXPCost();
        }
      }
    });
    this.management = experiencePoints;
    this.view = overview;
  }

  @Override
  public void initPresentation() {
    OverviewCategory category = view.addOverviewCategory(getString("Overview.Experience.Title"));
    for (IValueModel<Integer> model : management.getAllModels()) {
      IValueView<Integer> valueView = category.addIntegerValueView(getString("Overview.Experience." + model.getId()), 2);
      presenters.add(new ValueSubPresenter(model, valueView));
    }
    initTotal(category);
    calculateXPCost();
  }

  private void initTotal(OverviewCategory category) {
    totalView = category.addAlotmentView(getString("Overview.Experience.Total"), 4);
    ExperienceModelFetcher.fetch(hero).getExperiencePoints().addExperiencePointConfigurationListener(new ExperiencePointConfigurationListener() {
      @Override
      public void entriesAddedRemovedOrChanged() {
        calculateXPCost();
      }
    });
  }

  private void calculateXPCost() {
    for (IOverviewSubPresenter presenter : presenters) {
      presenter.update();
    }
    totalView.setAllotment(getTotalXP());
    setTotalViewColor();
    totalView.setValue(management.getTotalCosts());
    setTotalViewColor();
  }

  private void setTotalViewColor() {
    boolean overspent = management.getTotalCosts() > getTotalXP();
    totalView.setTextColor(overspent ? LegalityColorProvider.COLOR_HIGH : LegalityColorProvider.COLOR_OKAY);
  }

  private int getTotalXP() {
    return ExperienceModelFetcher.fetch(hero).getExperiencePoints().getTotalExperiencePoints();
  }

  private String getString(String string) {
    return resources.getString(string);
  }
}
