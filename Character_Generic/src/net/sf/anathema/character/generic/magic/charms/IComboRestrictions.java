package net.sf.anathema.character.generic.magic.charms;

import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

public interface IComboRestrictions {

  boolean combosAllAbilities();
  
  boolean combosSelectAbility(IAbilityType type);

  boolean isComboAllowed(boolean isAllowedByDefault);

  boolean isRestrictedCharm(ICharm charm);

  ITraitType[] getRestrictedTraitTypes();
}