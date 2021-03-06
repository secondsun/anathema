package net.sf.anathema.fx.hero.overview;

import javafx.scene.Node;
import net.sf.anathema.character.main.library.overview.OverviewCategory;
import net.sf.anathema.character.main.view.labelledvalue.IValueView;
import net.sf.anathema.character.main.view.labelledvalue.LabelledAllotmentView;
import net.sf.anathema.platform.fx.FxThreading;
import net.sf.anathema.platform.fx.StyledTitledPane;
import org.tbee.javafx.scene.layout.MigPane;

import static net.sf.anathema.lib.gui.layout.LayoutUtils.withoutInsets;

public class FxOverviewCategory implements OverviewCategory {
  private final MigPane panel = new MigPane(withoutInsets().wrapAfter(4));
  private Node border;

  public FxOverviewCategory(final MigPane parent, final String label) {
    FxThreading.runOnCorrectThread(new Runnable() {
      @Override
      public void run() {
        border = StyledTitledPane.Create(label, panel);
        parent.add(border);
      }
    });
  }

  @Override
  public LabelledAllotmentView addAlotmentView(String labelText, int maxValueLength) {
    FxAllotmentOverview view = new FxAllotmentOverview(labelText);
    view.addTo(panel);
    return view;
  }

  @Override
  public IValueView<Integer> addIntegerValueView(String labelText, int maxValueLength) {
    FxIntegerOverview view = new FxIntegerOverview(labelText);
    view.addTo(panel);
    return view;
  }

  @Override
  public IValueView<String> addStringValueView(String labelText) {
    FxStringOverview view = new FxStringOverview(labelText);
    view.addTo(panel);
    return view;
  }

  public Node getNode() {
    return border;
  }
}