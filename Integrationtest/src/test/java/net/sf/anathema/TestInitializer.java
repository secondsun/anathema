package net.sf.anathema;

import net.sf.anathema.framework.IApplicationModel;
import net.sf.anathema.initialization.ApplicationFrameView;
import net.sf.anathema.initialization.InitializationException;
import net.sf.anathema.initialization.InitializedModelAndView;
import net.sf.anathema.initialization.Initializer;
import net.sf.anathema.initialization.ObjectFactory;
import net.sf.anathema.lib.resources.Resources;
import net.sf.anathema.view.NullMainView;

import static net.sf.anathema.framework.configuration.InitializationPreferences.getDefaultPreferences;

public class TestInitializer extends Initializer {
  public TestInitializer() throws InitializationException {
    super(getDefaultPreferences());
  }

  public IApplicationModel initialize() {
    InitializedModelAndView dao = initializeModelViewAndPresentation();
    return dao.model;
  }

  @Override
  protected void showVersion(Resources resources) {
    //nothing to do
  }

  @Override
  protected void displayMessage(String message) {
    //nothing to do
  }

  @Override
  protected ApplicationFrameView initView(Resources resources, IApplicationModel anathemaModel, ObjectFactory objectFactory) {
    return new NullMainView();
  }
}