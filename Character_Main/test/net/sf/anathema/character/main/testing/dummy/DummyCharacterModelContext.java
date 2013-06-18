package net.sf.anathema.character.main.testing.dummy;

import net.sf.anathema.character.generic.IBasicCharacterData;
import net.sf.anathema.character.generic.additionalrules.IAdditionalRules;
import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModel;
import net.sf.anathema.character.generic.character.IGenericTraitCollection;
import net.sf.anathema.character.generic.character.ILimitationContext;
import net.sf.anathema.character.generic.character.IMagicCollection;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterListening;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.IGenericSpecialtyContext;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.TraitValueStrategy;
import net.sf.anathema.character.generic.framework.additionaltemplate.model.TraitContext;
import net.sf.anathema.character.generic.impl.template.magic.ICharmProvider;
import net.sf.anathema.character.generic.template.ITemplateRegistry;
import net.sf.anathema.character.generic.template.presentation.IPresentationProperties;
import net.sf.anathema.character.generic.type.CharacterTypes;
import net.sf.anathema.character.impl.model.context.BasicCharacterContext;
import net.sf.anathema.character.impl.model.context.trait.CreationTraitValueStrategy;
import net.sf.anathema.character.main.hero.InitializationContext;
import net.sf.anathema.character.model.ICharacter;

import java.util.List;

public class DummyCharacterModelContext implements ICharacterModelContext, InitializationContext {

  private final TraitValueStrategy valueStrategy;
  private DummyGenericCharacter character;
  private DummyHero dummyHero = new DummyHero();
  private TraitContext traitContext = new TraitContext() {

    @Override
    public TraitValueStrategy getTraitValueStrategy() {
      return valueStrategy;
    }

    @Override
    public ILimitationContext getLimitationContext() {
      return getCharacter();
    }
  };

  public DummyCharacterModelContext() {
    this(new CreationTraitValueStrategy());
  }

  @Override
  public IAdditionalModel getAdditionalModel(String id) {
    return character.getAdditionalModel(id);
  }

  public DummyCharacterModelContext(final TraitValueStrategy valueStrategy) {
    this.valueStrategy = valueStrategy;
    this.character = new DummyGenericCharacter(dummyHero.getTemplate());
  }

  public DummyGenericCharacter getCharacter() {
    return character;
  }

  @Override
  public ICharacter getHero() {
    throw new UnsupportedOperationException("Not yet implemented");
  }

  @Override
  public IAdditionalRules getAdditionalRules() {
    return getCharacter().getTemplate().getAdditionalRules();
  }

  @Override
  public IMagicCollection getMagicCollection() {
    return getCharacter();
  }

  @Override
  public IGenericTraitCollection getTraitCollection() {
    return getCharacter().getTraitCollection();
  }

  @Override
  public TraitContext getTraitContext() {
    return traitContext;
  }

  @Override
  public CharacterTypes getCharacterTypes() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ITemplateRegistry getTemplateRegistry() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ICharmProvider getCharmProvider() {
    throw new UnsupportedOperationException();
  }

  @Override
  public ICharacterListening getCharacterListening() {
    return dummyHero.listening;
  }

  @Override
  public IPresentationProperties getPresentationProperties() {
    return null;
  }

  @Override
  public IBasicCharacterData getBasicCharacterContext() {
    return new BasicCharacterContext(getCharacter());
  }

  @Override
  public <T> List<T> getAllRegistered(Class<T> interfaceClass) {
    return getCharacter().getAllRegistered(interfaceClass);
  }

  @Override
  public IGenericSpecialtyContext getSpecialtyContext() {
    return null;
  }
}
