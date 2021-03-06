package net.sf.anathema.hero.spiritual.display;

import net.sf.anathema.character.main.view.labelledvalue.IValueView;
import net.sf.anathema.framework.value.IntValueView;

public interface SpiritualTraitsView {

  void initGui(SpiritualTraitsViewProperties properties);

  IntValueView addVirtue(String labelText, int maxValue);

  IntValueView addWillpower(String labelText, int maxValue);

  IntValueView addEssenceView(String labelText, int maxValue);

  IValueView<String> addPoolView(String labelText);
}