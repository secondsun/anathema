package net.sf.anathema.character.generic.impl.magic.persistence;

import net.sf.anathema.character.generic.impl.magic.Charm;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.special.ISpecialCharm;
import net.sf.anathema.lib.exception.PersistenceException;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import net.sf.anathema.character.generic.magic.charms.CharmException;

public abstract class AbstractCharmSetBuilder implements ICharmSetBuilder {

    @Override
    public ICharm[] buildCharms(Document charmDoc, List<ISpecialCharm> specialCharms) throws PersistenceException {
        Collection<Charm> allCharms = new HashSet<>();
        Element charmListElement = charmDoc.getRootElement();
        buildCharms(allCharms, specialCharms, charmListElement);
        return allCharms.toArray(new ICharm[allCharms.size()]);
    }

    protected abstract void buildCharms(Collection<Charm> allCharms, List<ISpecialCharm> specialCharms, Element charmListElement)
            throws PersistenceException;

    protected final void createCharm(Collection<Charm> allCharms, List<ISpecialCharm> specialCharms,
            ICharmBuilder currentbuilder, Element charmElement)
            throws PersistenceException {
        try {
            Charm newCharm = currentbuilder.buildCharm(charmElement, specialCharms);
            if (allCharms.contains(newCharm)) {
                allCharms.remove(newCharm);
            }
            allCharms.add(newCharm);
        } catch (PersistenceException ignore) {//Need better checks.  This is to catch charms using abilities not enabled for the configuraiton.
            if (ignore.getCause() instanceof CharmException)
                return; 
            else 
                throw ignore;
        }

    }
}