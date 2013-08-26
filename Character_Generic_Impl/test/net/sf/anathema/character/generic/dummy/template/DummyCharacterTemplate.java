package net.sf.anathema.character.generic.dummy.template;

import net.sf.anathema.character.generic.additionalrules.IAdditionalRules;
import net.sf.anathema.character.generic.caste.ICasteCollection;
import net.sf.anathema.character.generic.caste.ICasteType;
import net.sf.anathema.character.generic.dummy.DummyMundaneCharacterType;
import net.sf.anathema.character.generic.impl.caste.CasteCollection;
import net.sf.anathema.character.generic.impl.template.essence.NullEssenceTemplate;
import net.sf.anathema.character.generic.impl.template.magic.CharmTemplate;
import net.sf.anathema.character.generic.impl.template.magic.DefaultMartialArtsRules;
import net.sf.anathema.character.generic.impl.template.magic.NullCharmSet;
import net.sf.anathema.character.generic.impl.traits.DummyTraitTemplateFactory;
import net.sf.anathema.character.generic.impl.traits.TraitTemplateCollection;
import net.sf.anathema.character.generic.magic.IMagic;
import net.sf.anathema.character.generic.magic.charms.MartialArtsLevel;
import net.sf.anathema.character.generic.template.ICharacterTemplate;
import net.sf.anathema.character.generic.template.ITemplateType;
import net.sf.anathema.character.generic.template.ITraitTemplateCollection;
import net.sf.anathema.character.generic.template.TemplateType;
import net.sf.anathema.character.generic.template.abilities.GroupedTraitType;
import net.sf.anathema.character.generic.template.additional.IAdditionalTemplate;
import net.sf.anathema.character.generic.template.creation.BonusPointCosts;
import net.sf.anathema.character.generic.template.creation.ICreationPoints;
import net.sf.anathema.character.generic.template.essence.IEssenceTemplate;
import net.sf.anathema.character.generic.template.experience.IExperiencePointCosts;
import net.sf.anathema.character.generic.template.magic.ICharmTemplate;
import net.sf.anathema.character.generic.template.magic.IMagicTemplate;
import net.sf.anathema.character.generic.template.magic.ISpellMagicTemplate;
import net.sf.anathema.character.generic.template.points.IAbilityCreationPoints;
import net.sf.anathema.character.generic.template.points.IAttributeCreationPoints;
import net.sf.anathema.character.generic.template.presentation.IPresentationProperties;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.types.AbilityType;
import net.sf.anathema.character.generic.traits.types.AttributeGroupType;
import net.sf.anathema.character.generic.traits.types.AttributeType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;
import net.sf.anathema.lib.exception.NotYetImplementedException;

public class DummyCharacterTemplate implements ICharacterTemplate {

  private static final String DUMMYGROUP = "DummyGroup";
  private final ITraitTemplateCollection traitTemplateCollection = new TraitTemplateCollection(
          new DummyTraitTemplateFactory());
  private ITemplateType type = new TemplateType(new DummyMundaneCharacterType());
  private IEssenceTemplate essenceTemplate = new NullEssenceTemplate();

  public void setEssenceTemplate(IEssenceTemplate essenceTemplate) {
    this.essenceTemplate = essenceTemplate;
  }

  @Override
  public BonusPointCosts getBonusPointCosts() {
    throw new NotYetImplementedException();
  }

  @Override
  public GroupedTraitType[] getAbilityGroups() {
    IAbilityType[] all = AbilityType.values();
    GroupedTraitType[] abilityTypes = new GroupedTraitType[all.length];
    for (int index = 0; index < all.length; index++) {
      abilityTypes[index] = new GroupedTraitType(all[index], DUMMYGROUP, null);
    }
    return abilityTypes;
  }

  @Override
  public ITemplateType getTemplateType() {
    return type;
  }

  @Override
  public IExperiencePointCosts getExperienceCost() {
    return null;
  }

  @Override
  public IPresentationProperties getPresentationProperties() {
    throw new NotYetImplementedException();
  }

  @Override
  public IAdditionalRules getAdditionalRules() {
    return new DummyAdditionalRules();
  }

  @Override
  public ICreationPoints getCreationPoints() {
    return new ICreationPoints() {

      @Override
      public int getBackgroundPointCount() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getBonusPointCount() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getVirtueCreationPoints() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getSpecialtyCreationPoints() {
        throw new NotYetImplementedException();
      }

      @Override
      public IAbilityCreationPoints getAbilityCreationPoints() {
        throw new NotYetImplementedException();
      }

      @Override
      public IAttributeCreationPoints getAttributeCreationPoints() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getFavoredCreationCharmCount() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getDefaultCreationCharmCount() {
        throw new NotYetImplementedException();
      }

      @Override
      public int getUniqueRequiredCreationCharmCount() {
        throw new NotYetImplementedException();
      }
    };
  }

  @Override
  public IEssenceTemplate getEssenceTemplate() {
    return essenceTemplate;
  }

  @Override
  public ICasteCollection getCasteCollection() {
    return new CasteCollection(new ICasteType[0]);
  }

  @Override
  public IMagicTemplate getMagicTemplate() {
    return new IMagicTemplate() {
      @Override
      public boolean canBuyFromFreePicks(IMagic magic) {
        return true;
      }

      @Override
      public ISpellMagicTemplate getSpellMagic() {
        throw new NotYetImplementedException();
      }

      @Override
      public ICharmTemplate getCharmTemplate() {
        return new CharmTemplate(new DefaultMartialArtsRules(MartialArtsLevel.Mortal), new NullCharmSet());
      }
    };
  }

  @Override
  public ITraitTemplateCollection getTraitTemplateCollection() {
    return traitTemplateCollection;
  }

  @Override
  public ITraitType[] getToughnessControllingTraitTypes() {
    return new ITraitType[]{AbilityType.Resistance};
  }

  @Override
  public IAdditionalTemplate[] getAdditionalTemplates() {
    return new IAdditionalTemplate[0];
  }

  @Override
  public GroupedTraitType[] getAttributeGroups() {
    return new GroupedTraitType[]{new GroupedTraitType(AttributeType.Strength, AttributeGroupType.Physical.getId(),
            null), new GroupedTraitType(AttributeType.Dexterity, AttributeGroupType.Physical.getId(),
            null), new GroupedTraitType(AttributeType.Stamina, AttributeGroupType.Physical.getId(),
            null), new GroupedTraitType(AttributeType.Charisma, AttributeGroupType.Social.getId(),
            null), new GroupedTraitType(AttributeType.Manipulation, AttributeGroupType.Social.getId(),
            null), new GroupedTraitType(AttributeType.Appearance, AttributeGroupType.Social.getId(),
            null), new GroupedTraitType(AttributeType.Perception, AttributeGroupType.Mental.getId(),
            null), new GroupedTraitType(AttributeType.Intelligence, AttributeGroupType.Mental.getId(),
            null), new GroupedTraitType(AttributeType.Wits, AttributeGroupType.Mental.getId(), null),};
  }

  @Override
  public String[] getBaseHealthProviders() {
    return new String[0];
  }

  @Override
  public boolean isNpcOnly() {
    return false;
  }

  @Override
  public boolean isCustomTemplate() {
	  return false;
  }
}