package net.sf.anathema.character.generic.traits.types;

public enum AbilityTypeModern implements IAbilityType {
  Archery,
  MartialArts,
  Melee,
  Thrown,
  War,
  Firearms,
  Integrity,
  Performance,
  Presence,
  Resistance,
  Survival,
  Craft,
  Investigation,
  Lore,
  Medicine,
  Occult,
  Athletics,
  Awareness,
  Dodge,
  Larceny,
  Stealth,
  Bureaucracy,
  Linguistics,
  Ride,
  Drive,
  Sail,
  Socialize;

  @Override
  public void accept(ITraitTypeVisitor visitor) {
    visitor.visitAbility(this);
  }

  @Override
  public String getId() {
    return name();
  }
}