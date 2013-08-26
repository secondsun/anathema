package net.sf.anathema.character.generic.magic.charms;

import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.type.CharmType;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

import java.util.ArrayList;
import java.util.List;

public class ComboRestrictions implements IComboRestrictions {

  private final boolean allAbilities;
  private final String[] selectAbilities;
  private final Boolean combosAllowed;
  private final List<String> restrictedCharmIds = new ArrayList<>();
  private final List<CharmType> restrictedCharmTypes = new ArrayList<>();
  private final List<ITraitType> restrictedTraitTypes = new ArrayList<>();

  public ComboRestrictions() {
    this(false, null);
  }

  public ComboRestrictions(boolean allAbilities, Boolean combosAllowed) {
    this(allAbilities, "", combosAllowed);
  }

  public ComboRestrictions(boolean allAbilities, String selectAbilities, Boolean combosAllowed) {
    this.allAbilities = allAbilities;
    this.combosAllowed = combosAllowed;
    this.selectAbilities = selectAbilities.split(",");
  }

  public void addRestrictedCharmId(String charmId) {
    restrictedCharmIds.add(charmId);
  }

  public void addRestrictedCharmType(CharmType charmType) {
    restrictedCharmTypes.add(charmType);
  }

  public void addRestrictedTraitType(ITraitType traitType) {
    restrictedTraitTypes.add(traitType);
  }

  @Override
  public boolean combosAllAbilities() {
    return allAbilities;
  }

  @Override
  public boolean combosSelectAbility(IAbilityType type) {
    for (String ability : selectAbilities)
      if (type.getId().equals(ability)) return true;
    return false;
  }

  @Override
  public ITraitType[] getRestrictedTraitTypes() {
    return restrictedTraitTypes.toArray(new ITraitType[restrictedTraitTypes.size()]);
  }

  @Override
  public boolean isComboAllowed(boolean isAllowedByDefault) {
    return combosAllowed == null ? isAllowedByDefault : combosAllowed;
  }

  @Override
  public boolean isRestrictedCharm(ICharm charm) {
    if (restrictedCharmTypes.contains(charm.getCharmTypeModel().getCharmType())) {
      return true;
    }
    return restrictedCharmIds.contains(charm.getId());
  }
}