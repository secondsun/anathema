package net.sf.anathema.character.generic.traits.types;

import net.sf.anathema.configuration.AnathemaCharacterPreferences;

public class AbilityType implements IAbilityType {

    public static final IAbilityType Archery,
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

    static {
        if (AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities()) {
            Archery = AbilityTypeModern.Archery;
            MartialArts = AbilityTypeModern.MartialArts;
            Melee = AbilityTypeModern.Melee;
            Thrown = AbilityTypeModern.Thrown;
            War = AbilityTypeModern.War;
            Firearms = AbilityTypeModern.Firearms;
            Integrity = AbilityTypeModern.Integrity;
            Performance = AbilityTypeModern.Performance;
            Presence = AbilityTypeModern.Presence;
            Resistance = AbilityTypeModern.Resistance;
            Survival = AbilityTypeModern.Survival;
            Craft = AbilityTypeModern.Craft;
            Investigation = AbilityTypeModern.Investigation;
            Lore = AbilityTypeModern.Lore;
            Medicine = AbilityTypeModern.Medicine;
            Occult = AbilityTypeModern.Occult;
            Athletics = AbilityTypeModern.Athletics;
            Awareness = AbilityTypeModern.Awareness;
            Dodge = AbilityTypeModern.Dodge;
            Larceny = AbilityTypeModern.Larceny;
            Stealth = AbilityTypeModern.Stealth;
            Bureaucracy = AbilityTypeModern.Bureaucracy;
            Linguistics = AbilityTypeModern.Linguistics;
            Ride = AbilityTypeModern.Ride;
            Drive = AbilityTypeModern.Drive;
            Sail = AbilityTypeModern.Sail;
            Socialize = AbilityTypeModern.Socialize;
        } else {
            Archery = AbilityTypeClassic.Archery;
            MartialArts = AbilityTypeClassic.MartialArts;
            Melee = AbilityTypeClassic.Melee;
            Thrown = AbilityTypeClassic.Thrown;
            War = AbilityTypeClassic.War;
            Firearms = null;
            Integrity = AbilityTypeClassic.Integrity;
            Performance = AbilityTypeClassic.Performance;
            Presence = AbilityTypeClassic.Presence;
            Resistance = AbilityTypeClassic.Resistance;
            Survival = AbilityTypeClassic.Survival;
            Craft = AbilityTypeClassic.Craft;
            Investigation = AbilityTypeClassic.Investigation;
            Lore = AbilityTypeClassic.Lore;
            Medicine = AbilityTypeClassic.Medicine;
            Occult = AbilityTypeClassic.Occult;
            Athletics = AbilityTypeClassic.Athletics;
            Awareness = AbilityTypeClassic.Awareness;
            Dodge = AbilityTypeClassic.Dodge;
            Larceny = AbilityTypeClassic.Larceny;
            Stealth = AbilityTypeClassic.Stealth;
            Bureaucracy = AbilityTypeClassic.Bureaucracy;
            Linguistics = AbilityTypeClassic.Linguistics;
            Ride = AbilityTypeClassic.Ride;
            Drive = null;
            Sail = AbilityTypeClassic.Sail;
            Socialize = AbilityTypeClassic.Socialize;
        }
    }

    @Override
    public void accept(ITraitTypeVisitor visitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
