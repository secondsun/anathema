package net.sf.anathema.hero.description;

import net.sf.anathema.hero.model.Hero;

public class HeroDescriptionFetcher {

  public static HeroDescription fetch(Hero hero) {
    return hero.getModel(HeroDescription.ID);
  }
}
