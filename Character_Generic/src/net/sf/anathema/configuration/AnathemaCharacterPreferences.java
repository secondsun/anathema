package net.sf.anathema.configuration;

import java.util.prefs.Preferences;

import static net.sf.anathema.configuration.ICharacterPreferencesConstants.CHARACTER_PREFERENCES_NODE;
import static net.sf.anathema.configuration.ICharacterPreferencesConstants.PRINT_ALL_GENERICS;
import static net.sf.anathema.configuration.ICharacterPreferencesConstants.PRINT_ZERO_BACKGROUNDS;
import static net.sf.anathema.configuration.ICharacterPreferencesConstants.PRINT_ZERO_CRAFTS;
import static net.sf.anathema.configuration.ICharacterPreferencesConstants.PRINT_ZERO_INTIMACIES;
import static net.sf.anathema.configuration.ICharacterPreferencesConstants.ENABLE_MODERN_ABILITIES;

public class AnathemaCharacterPreferences implements IAnathemaCharacterPreferences {
  private static final IAnathemaCharacterPreferences instance = new AnathemaCharacterPreferences(Preferences.userRoot()
      .node(CHARACTER_PREFERENCES_NODE));

  private final Preferences characterPreferences;

  public AnathemaCharacterPreferences(Preferences rootPreference) {
    this.characterPreferences = rootPreference;
  }

  public static IAnathemaCharacterPreferences getDefaultPreferences() {
    return instance;
  }

  @Override
  public boolean printZeroBackgrounds() {
    return characterPreferences.getBoolean(PRINT_ZERO_BACKGROUNDS, true);
  }

  @Override
  public boolean enableModernAbilities() {
    return characterPreferences.getBoolean(ENABLE_MODERN_ABILITIES, false);
  }
  
  @Override
  public boolean printZeroCrafts() {
    return characterPreferences.getBoolean(PRINT_ZERO_CRAFTS, true);
  }

  @Override
  public boolean printZeroIntimacies() {
    return characterPreferences.getBoolean(PRINT_ZERO_INTIMACIES, true);
  }
  
  @Override
  public boolean printAllGenerics() {
	return characterPreferences.getBoolean(PRINT_ALL_GENERICS, false);
  }
}