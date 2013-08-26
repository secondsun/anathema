package net.sf.anathema.character.generic.traits.groups;

import net.sf.anathema.character.generic.traits.types.AbilityTypeClassic;
import net.sf.anathema.character.generic.traits.types.AbilityTypeModern;
import net.sf.anathema.character.generic.traits.types.IAbilityType;
import net.sf.anathema.configuration.AnathemaCharacterPreferences;

public class AllAbilityTraitTypeGroup extends TraitTypeGroup {

  private static final AllAbilityTraitTypeGroup instance;

  private static final IAbilityType[] abilityValues;

  static {
      if (AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities()) {
          abilityValues = AbilityTypeModern.values();
          instance = new AllAbilityTraitTypeGroup();
      } else {
          abilityValues = AbilityTypeClassic.values();
          instance = new AllAbilityTraitTypeGroup();
      }
  }
  public static AllAbilityTraitTypeGroup getInstance() {
    return instance;
  }

  private AllAbilityTraitTypeGroup() {
    super(abilityValues);
  }
}