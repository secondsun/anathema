package net.sf.anathema.character.impl.costs;

import net.sf.anathema.character.dummy.generic.DummyAdditionalBonusPointManagment;
import net.sf.anathema.character.dummy.trait.DummyCoreTraitConfiguration;
import net.sf.anathema.character.generic.impl.template.points.AbilityCreationPoints;
import net.sf.anathema.character.generic.impl.template.points.FixedValueRatingCosts;
import net.sf.anathema.character.generic.template.experience.AbilityPointCosts;
import net.sf.anathema.character.generic.template.experience.CurrentRatingCosts;
import net.sf.anathema.character.generic.template.points.IFavorableTraitCreationPoints;
import net.sf.anathema.character.generic.traits.types.AbilityType;
import net.sf.anathema.character.impl.model.creation.bonus.ability.AbilityCostCalculator;
import net.sf.anathema.character.library.trait.FavorableTraitCost;
import net.sf.anathema.character.library.trait.IFavorableDefaultTrait;
import net.sf.anathema.character.library.trait.favorable.IFavorableTrait;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import net.sf.anathema.character.generic.traits.types.IAbilityType;

import static org.junit.Assert.assertEquals;

public class AbilityCostCalculatorTest extends AbstractBonusPointTestCase {

  private static class DummyAbilityPointCosts implements AbilityPointCosts {

    private final CurrentRatingCosts defaultCosts = new FixedValueRatingCosts(2);
    private final CurrentRatingCosts favoredCosts = new FixedValueRatingCosts(1);

    @Override
    public CurrentRatingCosts getAbilityCosts(boolean favored) {
      return favored ? favoredCosts : defaultCosts;
    }

    @Override
    public int getDefaultSpecialtyDotsPerPoint() {
      return 1;
    }

    @Override
    public int getFavoredSpecialtyDotsPerPoint() {
      return 2;
    }

    @Override
    public int getMaximumFreeAbilityRank() {
      return 3;
    }
  }

  private static void assertEmptyCosts(AbilityCostCalculator calculator, IFavorableTrait ability) {
    FavorableTraitCost[] abilityCost = calculator.getCosts(ability);
    if (ability.getType() == AbilityType.Craft) {
      return;
    }
    assertEquals("Ability " + ability, 0, abilityCost[0].getBonusCost());
    assertEquals("Ability " + ability, 0, abilityCost[0].getFavoredPointCost());
    assertEquals("Ability " + ability, 0, abilityCost[0].getGeneralPointCost());
  }

  private DummyCoreTraitConfiguration traitConfiguration;
  private AbilityPointCosts costs;
  private DummyAdditionalBonusPointManagment additionalBonusPointManagment;

  private IFavorableDefaultTrait setFavoredAbilityTo(IAbilityType abilityType, int value) {
    IFavorableDefaultTrait trait = (IFavorableDefaultTrait) traitConfiguration.getFavorableTrait(abilityType);
    trait.getFavorization().updateFavorableStateToCaste();
    trait.getFavorization().setFavored(true);
    trait.setCreationValue(value);
    return trait;
  }

  private IFavorableDefaultTrait setUnfavoredAbilityTo(IAbilityType abilityType, int value) {
    IFavorableDefaultTrait ability = (IFavorableDefaultTrait) traitConfiguration.getFavorableTrait(abilityType);
    ability.getFavorization().updateFavorableStateToCaste();
    ability.getFavorization().setFavored(false);
    ability.setCreationValue(value);
    return ability;
  }

  @Before
  public void setUp() throws Exception {
    traitConfiguration = new DummyCoreTraitConfiguration();
    addAbilityAndEssence(traitConfiguration);
    costs = new DummyAbilityPointCosts();
    additionalBonusPointManagment = new DummyAdditionalBonusPointManagment();
  }

  private AbilityCostCalculator startCalculation(IFavorableTraitCreationPoints creationPoints) {
    AbilityCostCalculator calculator = new AbilityCostCalculator(traitConfiguration, creationPoints, 0, costs, additionalBonusPointManagment);
    calculator.calculateCosts();
    return calculator;
  }

  @Test
  public void testAllAbilitiesUnlearned() throws Exception {
    AbilityCostCalculator calculator = startCalculation(new AbilityCreationPoints(2, 3, 4));
    assertEquals(0, calculator.getFreePointsSpent(true));
    assertEquals(0, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      assertEmptyCosts(calculator, ability);
    }
  }

  private List<IFavorableTrait> getAllAbilities() {
    List<IFavorableTrait> abilities = new ArrayList<>();
    for (IAbilityType type : AbilityType.values()) {
      IFavorableTrait trait = traitConfiguration.getFavorableTrait(type);
      abilities.add(trait);
    }
    return abilities;
  }

  @Test
  public void testPreferFavoredForBonusPoint() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 3, 2);
    IFavorableDefaultTrait firstFavored = setFavoredAbilityTo(AbilityType.Melee, 3);
    IFavorableDefaultTrait secondFavored = setFavoredAbilityTo(AbilityType.Ride, 3);
    IFavorableDefaultTrait unfavoredAbility = setUnfavoredAbilityTo(AbilityType.Archery, 3);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(3, calculator.getFreePointsSpent(true));
    assertEquals(2, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == firstFavored) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 0, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 3, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 0, abilityCost.getGeneralPointCost());
      } else if (ability == secondFavored) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 3, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 0, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 0, abilityCost.getGeneralPointCost());
      } else if (ability == unfavoredAbility) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 2, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 0, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 2, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }

  @Test
  public void testGeneralDotsUsedForFavoredAbilitiesOverFavoredDots() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 4, 5);
    IFavorableDefaultTrait firstFavored = setFavoredAbilityTo(AbilityType.Melee, 3);
    IFavorableDefaultTrait secondFavored = setFavoredAbilityTo(AbilityType.Occult, 3);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(4, calculator.getFreePointsSpent(true));
    assertEquals(2, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == firstFavored) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 0, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 3, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 0, abilityCost.getGeneralPointCost());
      } else if (ability == secondFavored) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 0, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 1, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 2, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }

  @Test
  public void testFavoredDotsForFavoredAbilitiesLessThan3() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 3, 4);
    IFavorableDefaultTrait favoredAbility = setFavoredAbilityTo(AbilityType.Melee, 3);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(3, calculator.getFreePointsSpent(true));
    assertEquals(0, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == favoredAbility) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 0, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 3, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 0, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }

  @Test
  public void testGeneralDotsForUnfavoredAbilityLessThan3() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 3, 4);
    IFavorableTrait unfavoredAbility = setUnfavoredAbilityTo(AbilityType.Archery, 3);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(0, calculator.getFreePointsSpent(true));
    assertEquals(3, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == unfavoredAbility) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 0, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 0, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 3, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }

  @Test
  public void testBonusPointsForFavoredAbilityAbove3() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 3, 4);
    IFavorableTrait favoredAbility = setFavoredAbilityTo(AbilityType.Melee, 4);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(3, calculator.getFreePointsSpent(true));
    assertEquals(0, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == favoredAbility) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 1, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 3, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 0, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }

  @Test
  public void testRaiseUnfavoredAbilityAbove3() throws Exception {
    IFavorableTraitCreationPoints abilityCreationPoints = new AbilityCreationPoints(2, 3, 4);
    IFavorableTrait unfavoredAbility = setUnfavoredAbilityTo(AbilityType.Archery, 4);
    AbilityCostCalculator calculator = startCalculation(abilityCreationPoints);
    assertEquals(0, calculator.getFreePointsSpent(true));
    assertEquals(3, calculator.getFreePointsSpent(false));
    for (IFavorableTrait ability : getAllAbilities()) {
      if (ability == unfavoredAbility) {
        FavorableTraitCost[] allAbilityCost = calculator.getCosts(ability);
        FavorableTraitCost abilityCost = allAbilityCost[0];
        assertEquals("Ability " + ability, 2, abilityCost.getBonusCost());
        assertEquals("Ability " + ability, 0, abilityCost.getFavoredPointCost());
        assertEquals("Ability " + ability, 3, abilityCost.getGeneralPointCost());
      } else {
        assertEmptyCosts(calculator, ability);
      }
    }
  }
}