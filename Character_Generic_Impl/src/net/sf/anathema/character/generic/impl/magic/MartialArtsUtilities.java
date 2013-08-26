package net.sf.anathema.character.generic.impl.magic;

import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.MartialArtsLevel;
import net.sf.anathema.lib.util.Identifier;

import java.text.MessageFormat;

import static net.sf.anathema.character.generic.magic.ICharmData.FORM_ATTRIBUTE;
import net.sf.anathema.character.generic.traits.types.AbilityTypeClassic;
import net.sf.anathema.character.generic.traits.types.AbilityTypeModern;
import net.sf.anathema.configuration.AnathemaCharacterPreferences;

public class MartialArtsUtilities {

  public static final Identifier MARTIAL_ARTS;
  
  static {
      if (AnathemaCharacterPreferences.getDefaultPreferences().enableModernAbilities()) {
          MARTIAL_ARTS = new Identifier(AbilityTypeModern.MartialArts.name());
      } else {
          MARTIAL_ARTS = new Identifier(AbilityTypeClassic.MartialArts.name());
      }
  }

  public static boolean isMartialArtsCharm(ICharm charm) {
    return charm.hasAttribute(MARTIAL_ARTS);
  }

  public static boolean isFormCharm(ICharm charm) {
    return charm.hasAttribute(FORM_ATTRIBUTE);
  }

  public static MartialArtsLevel getLevel(ICharm charm) {
    if (!isMartialArtsCharm(charm)) {
      return null;
    }
    for (MartialArtsLevel level : MartialArtsLevel.values()) {
      if (charm.hasAttribute(new Identifier(level.name()))) {
        return level;
      }
    }
    String pattern = "Martial Arts Charm without level: {0}. Please ensure it has a Martial Arts level as a 'charmAttribute'.";
    String message = MessageFormat.format(pattern, charm.getId());
    throw new IllegalStateException(message);
  }

  public static boolean hasLevel(MartialArtsLevel level, ICharm charm) {
    return charm.hasAttribute(new Identifier(level.name()));
  }
}