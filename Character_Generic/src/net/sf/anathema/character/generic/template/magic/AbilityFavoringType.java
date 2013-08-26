package net.sf.anathema.character.generic.template.magic;

import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.configuration.AnathemaCharacterPreferences;
import net.sf.anathema.character.generic.traits.types.AbilityTypeClassic;
import net.sf.anathema.character.generic.traits.types.AbilityTypeModern;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

public class AbilityFavoringType implements FavoringTraitType {
    
  private final IAbilityType[] abilityValues;
  private final IAbilityType occultType;

  {
      if (AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities()) {
          abilityValues = AbilityTypeModern.values();
          occultType = AbilityTypeModern.Occult;
      } else {
          abilityValues = AbilityTypeClassic.values();
          occultType = AbilityTypeClassic.Occult;
      }
  } 
    
  @Override
  public IAbilityType[] getTraitTypesForGenericCharms() {
    return abilityValues;
  }

  @Override
  public ITraitType getSpellFavoringType() {
    return occultType;
  }
  @Override
  public String getId() {
    return "AbilityType";
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof AbilityFavoringType;
  }

  @Override
  public int hashCode() {
    return 1;
  }
}