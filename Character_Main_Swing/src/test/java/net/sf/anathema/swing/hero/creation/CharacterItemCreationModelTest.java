package net.sf.anathema.swing.hero.creation;

import net.sf.anathema.character.main.CharacterStatisticsConfiguration;
import net.sf.anathema.character.main.template.HeroTemplate;
import net.sf.anathema.character.main.template.ITemplateRegistry;
import net.sf.anathema.hero.dummy.DummyCharacterTypes;
import net.sf.anathema.hero.dummy.DummyMundaneCharacterType;
import net.sf.anathema.hero.dummy.template.SimpleDummyCharacterTemplate;
import net.sf.anathema.character.main.type.CharacterType;
import net.sf.anathema.hero.framework.HeroEnvironment;
import net.sf.anathema.lib.control.ChangeListener;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class CharacterItemCreationModelTest {

  @Test
  public void comparesNewlySetCharacterTypeViaEqualsNotIdentity() throws Exception {
    HeroEnvironment generics = createGenericsWithCharacterType(new DummyMundaneCharacterType());
    CharacterStatisticsConfiguration configuration = mock(CharacterStatisticsConfiguration.class);
    CharacterItemCreationModel model = new CharacterItemCreationModel(generics, configuration);
    ChangeListener listener = mock(ChangeListener.class);
    model.addListener(listener);
    model.setCharacterType(new DummyMundaneCharacterType());
    verifyZeroInteractions(listener);
  }

  private HeroEnvironment createGenericsWithCharacterType(CharacterType characterType) {
    HeroEnvironment generics = mock(HeroEnvironment.class);
    DummyCharacterTypes characterTypes = new DummyCharacterTypes();
    characterTypes.add(characterType);
    when(generics.getCharacterTypes()).thenReturn(characterTypes);
    ITemplateRegistry registry = mock(ITemplateRegistry.class);
    SimpleDummyCharacterTemplate characterTemplate = new SimpleDummyCharacterTemplate(characterType, null);
    when(registry.getDefaultTemplate(characterType)).thenReturn(characterTemplate);
    when(registry.getAllSupportedTemplates(characterType)).thenReturn(
            new HeroTemplate[]{characterTemplate});
    when(generics.getTemplateRegistry()).thenReturn(registry);
    return generics;
  }
}
