package net.sf.anathema.character.generic.traits.types;

import net.sf.anathema.configuration.AnathemaCharacterPreferences;
import net.sf.anathema.lib.exception.ModernAbilityInClassicSettingException;

public abstract class AbilityType {
    
    private static final boolean enableModern = AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities();
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
    private static final IAbilityType[] VALUES;
    
    static {
        if (enableModern) {
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
            
            VALUES = new IAbilityType[]{
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
                Socialize
            };
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
            
            VALUES = new IAbilityType[]{
                Archery,
                MartialArts,
                Melee,
                Thrown,
                War,
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
                Sail,
                Socialize
            };
        }
    }
    
    public static IAbilityType valueOf(String value) {
        if (enableModern) {
            return AbilityTypeModern.valueOf(value);
        } else {
            try {
                return AbilityTypeClassic.valueOf(value);
            } catch (IllegalArgumentException ignore) {
                AbilityTypeModern.valueOf(value);
                throw new ModernAbilityInClassicSettingException();
            }
        }
    }
    
    public static IAbilityType[] values() {
        return VALUES;
    }
    
}
