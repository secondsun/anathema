package net.sf.anathema.character.main.xml.trait;

import net.sf.anathema.character.main.template.ITraitLimitation;
import net.sf.anathema.character.main.traits.LowerableState;
import net.sf.anathema.character.main.traits.TraitType;
import net.sf.anathema.character.main.traits.limitation.AgeBasedLimitation;
import net.sf.anathema.character.main.traits.limitation.EssenceBasedLimitation;
import net.sf.anathema.character.main.traits.limitation.StaticTraitLimitation;
import net.sf.anathema.lib.exception.PersistenceException;
import net.sf.anathema.lib.xml.ElementUtilities;
import org.dom4j.Element;

public class GenericTraitTemplateParser {

  private static final String ATTRIB_START_VALUE = "startValue";
  private static final String ATTRIB_ZERO_LEVEL = "zeroLevel";
  private static final String ATTRIB_LOWERABLE_STATE = "lowerableState";
  private static final String ATTRIB_VALUE = "value";
  private static final String ATTRIB_TYPE = "type";
  private static final String ATTRIB_USES = "uses";
  private static final String ATTRIB_IS_REQUIRED_FAVORED = "isRequiredFavored";
  private static final String ATTRIB_MINIMUM = "minimum";
  private static final String ATTRIB_FREEBIE = "isFreebie";
  private static final String TAG_MINIMUM = "minimum";
  private static final String TAG_LIMITATION = "limitation";
  private static final String VALUE_STATIC = "Static";
  private static final String VALUE_ESSENCE = "Essence";
  private static final String VALUE_AGE = "Age";

  public static IClonableTraitTemplate parseTraitTemplate(Element traitElement) throws PersistenceException {
    return parseTraitTemplate(traitElement, null);
  }

  public static IClonableTraitTemplate parseTraitTemplate(Element traitElement, TraitType type) throws PersistenceException {
    GenericTraitTemplate defaultTraitTemplate = new GenericTraitTemplate();
    int startValue = ElementUtilities.getRequiredIntAttrib(traitElement, ATTRIB_START_VALUE);
    defaultTraitTemplate.setStartValue(startValue);
    defaultTraitTemplate.setZeroLevelValue(ElementUtilities.getIntAttrib(traitElement, ATTRIB_ZERO_LEVEL, startValue));
    defaultTraitTemplate.setRequiredFavored(ElementUtilities.getBooleanAttribute(traitElement, ATTRIB_IS_REQUIRED_FAVORED, false));
    String lowerableStateId = ElementUtilities.getRequiredAttrib(traitElement, ATTRIB_LOWERABLE_STATE);
    defaultTraitTemplate.setLowerableState(LowerableState.valueOf(lowerableStateId));
    defaultTraitTemplate.setLimitation(parseLimitation(traitElement));
    defaultTraitTemplate.setIsFreebie(ElementUtilities.getBooleanAttribute(traitElement, ATTRIB_FREEBIE, false));
    Element minimumValueElement = ElementUtilities.getRequiredElement(traitElement, TAG_MINIMUM);
    String usesId = minimumValueElement.attributeValue(ATTRIB_USES);

    if (usesId != null) {
      IExtendedMinimum minimumClass = getMinimumClass(usesId);
      defaultTraitTemplate.setMinimumValue(minimumClass.getMinimum());
      return new GenericRestrictedTraitTemplate(defaultTraitTemplate, minimumClass, type);
    }

    defaultTraitTemplate.setMinimumValue(Integer.parseInt(minimumValueElement.attributeValue(ATTRIB_VALUE)));
    defaultTraitTemplate.setMinimumValue(ElementUtilities.getRequiredIntAttrib(minimumValueElement, ATTRIB_VALUE));

    return defaultTraitTemplate;
  }

  private static IExtendedMinimum getMinimumClass(String usesId) throws PersistenceException {
    try {
      return (IExtendedMinimum) Class.forName(usesId).newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      throw new PersistenceException(e);
    }
  }

  public static GenericTraitTemplate parseTraitTemplateSoft(Element traitElement) throws PersistenceException {
    GenericTraitTemplate defaultTraitTemplate = new GenericTraitTemplate();
    int startValue = ElementUtilities.getIntAttrib(traitElement, ATTRIB_START_VALUE, 0);
    defaultTraitTemplate.setStartValue(startValue);
    defaultTraitTemplate.setZeroLevelValue(ElementUtilities.getIntAttrib(traitElement, ATTRIB_ZERO_LEVEL, startValue));
    defaultTraitTemplate.setRequiredFavored(ElementUtilities.getBooleanAttribute(traitElement, ATTRIB_IS_REQUIRED_FAVORED, false));
    String lowerableStateId = traitElement.attributeValue(ATTRIB_LOWERABLE_STATE, LowerableState.Default.toString());
    defaultTraitTemplate.setLowerableState(LowerableState.valueOf(lowerableStateId));
    Element minimumValueElement = traitElement.element(TAG_MINIMUM);
    defaultTraitTemplate.setMinimumValue(minimumValueElement != null ? ElementUtilities.getRequiredIntAttrib(minimumValueElement, ATTRIB_VALUE) :
                                         ElementUtilities.getIntAttrib(traitElement, ATTRIB_MINIMUM, 0));
    if (traitElement.element(TAG_LIMITATION) != null) {
      defaultTraitTemplate.setLimitation(parseLimitation(traitElement));
    } else {
      defaultTraitTemplate.setLimitation(new EssenceBasedLimitation());
    }
    return defaultTraitTemplate;
  }

  private static ITraitLimitation parseLimitation(Element defaultTraitElement) throws PersistenceException {
    Element limitationElement = ElementUtilities.getRequiredElement(defaultTraitElement, TAG_LIMITATION);
    String usesId = limitationElement.attributeValue(ATTRIB_USES);
    if (usesId != null) {
      ITraitLimitation limitation = null;
      try {
        limitation = (ITraitLimitation) Class.forName(usesId).newInstance();
      } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
        e.printStackTrace();
      }
      return limitation;
    }
    String typeId = ElementUtilities.getRequiredAttrib(limitationElement, ATTRIB_TYPE);
    if (typeId.equals(VALUE_STATIC)) {
      int staticLimit = ElementUtilities.getRequiredIntAttrib(limitationElement, ATTRIB_VALUE);
      return new StaticTraitLimitation(staticLimit);
    }
    if (typeId.equals(VALUE_ESSENCE)) {
      return new EssenceBasedLimitation();
    }
    if (typeId.equals(VALUE_AGE)) {
      int staticLimit = ElementUtilities.getRequiredIntAttrib(limitationElement, ATTRIB_VALUE);
      return new AgeBasedLimitation(staticLimit);
    }
    throw new PersistenceException("Limitation Type not defined: " + typeId + ".");
  }
}