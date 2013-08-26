package net.sf.anathema.character.platform.module.preferences;

import net.sf.anathema.framework.module.preferences.AbstractCheckBoxPreferencesElement;
import net.sf.anathema.initialization.PreferenceElement;
import net.sf.anathema.initialization.reflections.Weight;
import net.sf.anathema.lib.util.Identified;

import static net.sf.anathema.character.generic.framework.configuration.ICharacterPreferencesConstants.ENABLE_MODERN_ABILITIES;

@PreferenceElement
@Weight(weight = 100)
public class EnableModernAbilitiesElement extends AbstractCheckBoxPreferencesElement implements ICharacterPreferencesElement {

  private boolean enableModernAbilities = CHARACTER_PREFERENCES.getBoolean(ENABLE_MODERN_ABILITIES, false);

  @Override
  public void savePreferences() {
    CHARACTER_PREFERENCES.putBoolean(ENABLE_MODERN_ABILITIES, enableModernAbilities);
  }

  @Override
  protected boolean getBooleanParameter() {
    return enableModernAbilities;
  }

  @Override
  protected String getLabelKey() {
    return "Character.Tools.Preferences.EnableModernAbilities";
  }

  @Override
  protected void resetValue() {
    enableModernAbilities = CHARACTER_PREFERENCES.getBoolean(ENABLE_MODERN_ABILITIES, false);
  }

  @Override
  protected void setValue(boolean value) {
    enableModernAbilities = value;
  }

  @Override
  public Identified getCategory() {
    return CHARACTER_CATEGORY;
  }
}