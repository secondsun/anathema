package net.sf.anathema.hero.intimacies.display;

import net.sf.anathema.character.main.framework.RegisteredCharacterView;
import net.sf.anathema.character.main.library.util.CssSkinner;
import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.character.main.view.SubViewFactory;
import net.sf.anathema.platform.fx.Stylesheet;

@RegisteredCharacterView(IntimaciesView.class)
public class IntimaciesViewFactory implements SubViewFactory {
  @SuppressWarnings("unchecked")
  @Override
  public <T> T create(CharacterType type) {
    FxIntimaciesView fxView = new FxIntimaciesView();
    String[] skins = new CssSkinner().getSkins(type);
    for (String skin : skins) {
      new Stylesheet(skin).applyToParent(fxView.getNode());
    }
    return (T) fxView;
  }
}