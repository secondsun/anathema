package net.sf.anathema.character.main.magic.parser.charms;

import com.google.common.base.Strings;
import net.sf.anathema.character.main.magic.charm.CharmException;
import net.sf.anathema.character.main.magic.charm.type.ICharmTypeVisitor;
import net.sf.anathema.character.main.magic.charm.type.CharmType;
import net.sf.anathema.character.main.magic.charm.type.CharmTypeModel;
import net.sf.anathema.character.main.magic.charm.type.ICharmTypeModel;
import net.sf.anathema.character.main.magic.charm.type.ISimpleSpecialsModel;
import net.sf.anathema.character.main.magic.charm.type.ITypeSpecialsModel;
import net.sf.anathema.character.main.magic.charm.type.ReflexiveSpecialsModel;
import net.sf.anathema.character.main.magic.charm.type.SimpleSpecialsModel;
import net.sf.anathema.character.main.magic.charm.type.TurnType;
import net.sf.anathema.lib.exception.PersistenceException;
import net.sf.anathema.lib.xml.ElementUtilities;
import org.dom4j.Element;

import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_DEFENSE;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_PRIMARY_STEP;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_SECONDARY_STEP;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_SPEED;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_TURN_TYPE;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.ATTRIB_TYPE;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.TAG_CHARMTYPE;
import static net.sf.anathema.character.main.magic.charm.ICharmXMLConstants.TAG_SPECIAL;

public class CharmTypeBuilder {

  public ICharmTypeModel build(Element rulesElement) throws CharmException {
    CharmType charmType;
    final Element typeElement = rulesElement.element(TAG_CHARMTYPE);
    try {
      charmType = CharmType.valueOf(typeElement.attributeValue(ATTRIB_TYPE));
    } catch (IllegalArgumentException e) {
      throw new CharmException("Bad type in charm. (Type unreadable)");
    } catch (NullPointerException e) {
      throw new CharmException("Bad type in charm. (Element required)");
    }

    final CharmTypeModel charmTypeModel = new CharmTypeModel();
    charmTypeModel.setCharmType(charmType);
    charmType.accept(new ICharmTypeVisitor() {
      @Override
      public void visitExtraAction(CharmType visitedType) {
        // Nothing to do
      }

      @Override
      public void visitReflexive(CharmType visitedType) {
        charmTypeModel.setSpecialModel(buildReflexiveModel(typeElement));
      }

      @Override
      public void visitSimple(CharmType visitedType) {
        charmTypeModel.setSpecialModel(buildSimpleModel(typeElement));
      }

      @Override
      public void visitSpecial(CharmType visitedType) {
        // Nothing to do
      }

      @Override
      public void visitPermanent(CharmType visitedType) {
        // Nothing to do
      }

      @Override
      public void visitSupplemental(CharmType visitedType) {
        // Nothing to do
      }
    });
    return charmTypeModel;
  }

  private ITypeSpecialsModel buildReflexiveModel(Element typeElement) {
    Element element = typeElement.element(TAG_SPECIAL);
    if (element == null) {
      return null;
    }
    try {
      Integer primaryStep = ElementUtilities.getRequiredIntOrVariesAttrib(element, ATTRIB_PRIMARY_STEP);
      String secondStepString = element.attributeValue(ATTRIB_SECONDARY_STEP);
      if (Strings.isNullOrEmpty(secondStepString)) {
        return new ReflexiveSpecialsModel(primaryStep, null);
      }
      Integer secondStep = Integer.valueOf(secondStepString);
      return new ReflexiveSpecialsModel(primaryStep, secondStep);
    } catch (PersistenceException e) {
      e.printStackTrace();
      return null;
    }
  }

  private ITypeSpecialsModel buildSimpleModel(Element typeElement) {
    Element element = typeElement.element(TAG_SPECIAL);
    if (element == null) {
      return null;
    }
    try {
      String attributeValue = element.attributeValue(ATTRIB_TURN_TYPE);
      TurnType type = TurnType.Tick;
      if (attributeValue != null) {
        type = TurnType.valueOf(attributeValue);
        if (type == TurnType.DramaticAction) {
          return new SimpleSpecialsModel(ISimpleSpecialsModel.DEFAULT_SPEED, type, ISimpleSpecialsModel.DEFAULT_DEFENSE_MODIFIER);
        }
      }
      int speed = ElementUtilities.getIntAttrib(element, ATTRIB_SPEED, ISimpleSpecialsModel.DEFAULT_SPEED);
      int defense = ElementUtilities.getIntAttrib(element, ATTRIB_DEFENSE, ISimpleSpecialsModel.DEFAULT_DEFENSE_MODIFIER);
      return new SimpleSpecialsModel(speed, type, defense);
    } catch (PersistenceException e) {
      e.printStackTrace();
      return null;
    }
  }
}