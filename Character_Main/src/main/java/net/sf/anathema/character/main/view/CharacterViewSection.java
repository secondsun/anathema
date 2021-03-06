package net.sf.anathema.character.main.view;

import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.framework.swing.IView;
import net.sf.anathema.hero.display.MultipleContentView;
import net.sf.anathema.hero.display.ContentProperties;
import net.sf.anathema.platform.fx.NodeHolder;

public class CharacterViewSection implements SectionView {

  private final MultipleContentView view;
  private final SubViewRegistry subViewFactory;

  public CharacterViewSection(CharacterPane characterPane, String title, SubViewRegistry subViewFactory) {
    this.view = characterPane.addMultipleContentView(title);
    this.subViewFactory = subViewFactory;
  }

  @Override
  public <T> T addView(String title, Class<T> viewClass, CharacterType type) {
    T newView = subViewFactory.get(viewClass, type);
    NodeHolder viewToAdd = (NodeHolder) newView;
    view.addView(viewToAdd, new ContentProperties(title));
    return newView;
  }

  @Override
  public void finishInitialization() {
    view.finishInitialization();
  }
}