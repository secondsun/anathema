/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.anathema.character.presenter.magic;

import javax.swing.JPanel;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.charmtree.filters.ICharmFilter;
import net.sf.anathema.lib.resources.Resources;
import org.dom4j.Element;

/**
 * This class will hide Firearms and Drive charms unless modern charms are enabled.
 */
public class ModernCharmFilter implements ICharmFilter {

    @Override
    public boolean acceptsCharm(ICharm charm, boolean isAncestor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDirty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apply() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Element parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load(Element node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getFilterPreferencePanel(Resources resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
