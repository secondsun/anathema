package net.sf.anathema.hero.charms.sheet.content.stats;

import net.sf.anathema.character.main.magic.charm.Charm;
import net.sf.anathema.hero.charms.display.MagicDisplayLabeler;
import net.sf.anathema.hero.charms.sheet.content.IMagicStats;
import net.sf.anathema.hero.charms.sheet.content.CharmContentHelper;
import net.sf.anathema.hero.model.Hero;
import net.sf.anathema.lib.resources.Resources;
import net.sf.anathema.lib.util.Identifier;
import net.sf.anathema.lib.util.SimpleIdentifier;

public class GenericCharmStats extends CharmStats {

  private final String genericId;

  public GenericCharmStats(Charm charm, Hero hero) {
    super(charm, new CharmContentHelper(hero));
    String charmId = charm.getId();
    genericId = charmId.substring(0, charmId.lastIndexOf('.'));
  }

  @Override
  public String[] getDetailStrings(Resources resources) {
    String description = resources.getString(getName() + ".Description.Short");
    return new String[]{description};
  }

  @Override
  public Identifier getName() {
    return new SimpleIdentifier(genericId);
  }

  @Override
  public String getNameString(Resources resources) {
    return new MagicDisplayLabeler(resources).getGenericLabelForMagic(getMagic());
  }

  @Override
  public final String getGroupName(Resources resources) {
    return resources.getString("Generics");
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof GenericCharmStats && this.getName().getId().equals(((GenericCharmStats) obj).getName().getId());
  }

  @Override
  public int compareTo(IMagicStats stats) {
    if (stats instanceof GenericCharmStats) {
      return this.getName().getId().compareTo(stats.getName().getId());
    } else {
      return -1;
    }
  }
}
