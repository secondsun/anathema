package net.sf.anathema.character.equipment.impl.character.model.stats;

import net.sf.anathema.character.equipment.impl.creation.model.WeaponTag;
import net.sf.anathema.character.generic.equipment.weapon.IEquipmentStats;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.types.AbilityType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

public class RangedWeaponStats extends AbstractWeaponStats {

  @Override
  public IAbilityType getTraitType() {
    return hasTag(WeaponTag.Gun)? AbilityType.Firearms : 
            hasTag(WeaponTag.Thrown) ? AbilityType.Thrown : AbilityType.Archery;
  }

  @Override
  public ITraitType getDamageTraitType() {
    return hasTag(WeaponTag.FlameType) || hasTag(WeaponTag.Gun) ||
    	hasTag(WeaponTag.FlatDamage) ? null : super.getDamageTraitType();
  }
  
  @Override
  public int getMobilityPenalty() {
	return 0;
  }

  @Override
  public IEquipmentStats[] getViews() {
    return new IEquipmentStats[] { this };
  }

}