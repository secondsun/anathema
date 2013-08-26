package net.sf.anathema.character.generic.impl.traits;

import net.sf.anathema.character.generic.backgrounds.IBackgroundTemplate;
import net.sf.anathema.character.generic.template.ITraitTemplateFactory;
import net.sf.anathema.character.generic.traits.ITraitTemplate;
import net.sf.anathema.character.generic.traits.LowerableState;
import net.sf.anathema.character.generic.traits.types.AttributeType;
import net.sf.anathema.character.generic.traits.types.IAbilityType;
import net.sf.anathema.character.generic.traits.types.VirtueType;

public class DummyTraitTemplateFactory implements ITraitTemplateFactory {

  @Override
  public ITraitTemplate createBackgroundTemplate(IBackgroundTemplate template) {
    return SimpleTraitTemplate.createStaticLimitedTemplate(0, 5, template.getExperiencedState());
  }
  
  @Override
  public ITraitTemplate createDefaultBackgroundTemplate() {
	return SimpleTraitTemplate.createStaticLimitedTemplate(0, 5, LowerableState.Default);
  }

  @Override
  public ITraitTemplate createWillpowerTemplate() {
    return SimpleTraitTemplate.createStaticLimitedTemplate(2, 10);
  }

  @Override
  public ITraitTemplate createEssenceTemplate() {
    return EssenceTemplate.createExaltTemplate();
  }

  @Override
  public ITraitTemplate createVirtueTemplate(VirtueType type) {
    return SimpleTraitTemplate.createStaticLimitedTemplate(1, 5);
  }

  @Override
  public ITraitTemplate createAttributeTemplate(AttributeType type) {
    return SimpleTraitTemplate.createEssenceLimitedTemplate(1);
  }

  @Override
  public ITraitTemplate createAbilityTemplate(IAbilityType type) {
    return SimpleTraitTemplate.createEssenceLimitedTemplate(0);
  }

}
