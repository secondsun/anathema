package net.sf.anathema.lib.gui.icon;

import net.sf.anathema.lib.control.ChangeListener;
import net.sf.anathema.lib.gui.action.IconUtilities;
import net.sf.anathema.lib.model.IChangeableModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

public class IconImageIcon extends ImageIcon {

  public IconImageIcon(final Icon icon) {
    super(createImage(icon));
    if (icon instanceof IChangeableModel) {
      IChangeableModel changeableModel = (IChangeableModel) icon;
      changeableModel.addChangeListener(new ChangeListener() {
        @Override
        public void changeOccurred() {
          setImage(createImage(icon));
        }
      });
    }
  }

  private static Image createImage(Icon icon) {
    return IconUtilities.createBufferedImage(icon);
  }

}
