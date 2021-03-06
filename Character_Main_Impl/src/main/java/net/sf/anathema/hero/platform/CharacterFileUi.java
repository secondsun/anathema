package net.sf.anathema.hero.platform;

import net.sf.anathema.character.main.CharacterUI;
import net.sf.anathema.character.main.framework.item.CharacterPrintNameFileScanner;
import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.framework.view.PrintNameFile;
import net.sf.anathema.hero.concept.CasteType;
import net.sf.anathema.lib.file.RelativePath;
import net.sf.anathema.lib.gui.AbstractUIConfiguration;
import net.sf.anathema.lib.resources.Resources;
import net.sf.anathema.lib.util.Identifier;
import net.sf.anathema.swing.hero.creation.CharacterTypeUi;

public class CharacterFileUi extends AbstractUIConfiguration<PrintNameFile> {

  private final Resources resources;
  private final CharacterPrintNameFileScanner scanner;

  public CharacterFileUi(Resources resources, CharacterPrintNameFileScanner scanner) {
    this.resources = resources;
    this.scanner = scanner;
  }

  @Override
  public RelativePath getIconsRelativePath(PrintNameFile value) {
    CharacterType characterType = scanner.getCharacterType(value);
    return new CharacterUI().getSmallTypeIconPath(characterType);
  }

  @Override
  public String getLabel(PrintNameFile value) {
    String printName = value.getPrintName();
    CharacterType characterType = scanner.getCharacterType(value);
    String characterString = new CharacterTypeUi(resources).getLabel(characterType);
    Identifier casteType = scanner.getCasteType(value);
    if (casteType == CasteType.NULL_CASTE_TYPE) {
      return resources.getString("LoadCharacter.PrintNameFile.ShortMessage", printName, characterString);
    }
    String casteTypeString = resources.getString("Caste." + casteType.getId());
    String casteString = resources.getString(characterType.getId() + ".Caste.Label");
    return resources.getString("LoadCharacter.PrintNameFile.Message", printName, characterString, casteTypeString, casteString);
  }
}