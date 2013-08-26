package net.sf.anathema.character.perspective;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.sf.anathema.character.perspective.model.CharacterIdentifier;
import net.sf.anathema.framework.view.ApplicationFrame;
import net.sf.anathema.lib.exception.ModernAbilityInClassicSettingException;

public class ShowOnSelect implements Selector<CharacterIdentifier> {

    private final CharacterStackPresenter characterStack;

    public ShowOnSelect(CharacterStackPresenter characterStack) {
        this.characterStack = characterStack;
    }

    @Override
    public void selected(CharacterIdentifier identifier) {
        try {
            characterStack.showCharacter(identifier);
        } catch (ModernAbilityInClassicSettingException ignore) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "This Character is using the Modern abilities.  It can not be opened unless modern abilities are enabled.", "Modern Chatacter Detected", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
}
