package net.sf.anathema.hero.languages.display.view;

import net.sf.anathema.character.main.framework.RegisteredCharacterView;
import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.character.main.view.SubViewFactory;
import net.sf.anathema.hero.languages.display.presenter.LanguagesView;

@RegisteredCharacterView(LanguagesView.class)
public class LanguagesViewFactory implements SubViewFactory {
  @SuppressWarnings("unchecked")
  @Override
  public <T> T create(CharacterType type) {
    return (T) new FxLanguagesView();
  }
}