package net.sf.anathema.hero.sheet.pdf.content;

import net.sf.anathema.hero.sheet.pdf.session.ReportSession;
import net.sf.anathema.lib.resources.Resources;

@RegisteredReportContent(produces = BasicContent.class)
public class BasicContentFactory implements ReportContentFactory<BasicContent> {

  @SuppressWarnings("UnusedDeclaration")
  public BasicContentFactory(Resources resources) {
    //Just to adhere to protocol
  }

  @Override
  public BasicContent create(ReportSession session) {
    return new BasicContent(session.getHero());
  }
}
