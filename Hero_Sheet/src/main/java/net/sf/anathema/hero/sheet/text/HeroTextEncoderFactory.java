package net.sf.anathema.hero.sheet.text;

import net.sf.anathema.framework.reporting.pdf.PdfReportUtils;
import net.sf.anathema.lib.resources.Resources;

public interface HeroTextEncoderFactory {

  HeroTextEncoder create(PdfReportUtils utils, Resources resources);
}
