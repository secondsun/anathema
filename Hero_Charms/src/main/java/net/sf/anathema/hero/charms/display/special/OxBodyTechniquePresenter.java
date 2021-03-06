package net.sf.anathema.hero.charms.display.special;

import net.sf.anathema.character.main.library.trait.presenter.TraitPresenter;
import net.sf.anathema.hero.charms.model.special.oxbody.OxBodyCategory;
import net.sf.anathema.hero.charms.model.special.oxbody.OxBodyTechniqueSpecials;
import net.sf.anathema.framework.value.IntValueView;
import net.sf.anathema.lib.gui.Presenter;
import net.sf.anathema.lib.resources.Resources;
import net.sf.anathema.platform.tree.display.CategorizedSpecialNodeView;

public class OxBodyTechniquePresenter implements Presenter {

  private final CategorizedSpecialNodeView view;
  private final OxBodyTechniqueSpecials model;
  private final Resources resources;

  public OxBodyTechniquePresenter(Resources resources, CategorizedSpecialNodeView view, OxBodyTechniqueSpecials model) {
    this.resources = resources;
    this.view = view;
    this.model = model;
  }

  @Override
  public void initPresentation() {
    for (OxBodyCategory category : model.getCategories()) {
      String label = resources.getString("OxBodyTechnique." + category.getId());
      IntValueView display = view.addCategory(label, category.getMaximalValue(), category.getCurrentValue());
      new TraitPresenter(category, display).initPresentation();
    }
  }
}
