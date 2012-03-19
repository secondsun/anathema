package net.sf.anathema.character.presenter;

import net.sf.anathema.character.generic.additionaltemplate.AdditionalModelType;
import net.sf.anathema.character.presenter.magic.IContentPresenter;

public interface MultiTabViewPresenter {
  void initMultiTabViewPresentation(String viewTitle, IContentPresenter presenter,
                                    AdditionalModelType additionalModelType);
}
