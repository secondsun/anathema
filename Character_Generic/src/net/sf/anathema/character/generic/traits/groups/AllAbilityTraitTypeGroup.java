package net.sf.anathema.character.generic.traits.groups;

import net.sf.anathema.character.generic.traits.types.AbilityTypeClassic;
import net.sf.anathema.character.generic.traits.types.AbilityTypeModern;
import net.sf.anathema.character.generic.traits.types.IAbilityType;
import net.sf.anathema.configuration.AnathemaCharacterPreferences;

public class AllAbilityTraitTypeGroup extends TraitTypeGroup {

  private static final AllAbilityTraitTypeGroup instance = new AllAbilityTraitTypeGroup();

  private static final IAbilityType[] abilityValues;

  static {
      if (AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities()) {
          abilityValues = AbilityTypeModern.values();
      } else {
          abilityValues = AbilityTypeClassic.values();
      }
  }
  public static AllAbilityTraitTypeGroup getInstance() {
    return instance;
  }

  private AllAbilityTraitTypeGroup() {
    super(abilityValues);
  }
}