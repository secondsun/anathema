package net.sf.anathema.character.generic.impl.social;

import net.sf.anathema.character.generic.character.IGenericTraitCollection;
import net.sf.anathema.character.generic.equipment.ICharacterStatsModifiers;
import net.sf.anathema.character.generic.traits.types.AbilityType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

public class InvestigationSocialAttack extends AbstractSocialAttack {

  public InvestigationSocialAttack(IGenericTraitCollection collection, ICharacterStatsModifiers equipmentModifiers) {
    super(collection, equipmentModifiers);
  }

  @Override
  public int getRate() {
    return 2;
  }

  @Override
  public int getSpeed() {
    return 5;
  }

  @Override
  public IAbilityType getName() {
    return AbilityType.Investigation;
  }
}