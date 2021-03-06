package net.sf.anathema.hero.sheet.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import net.sf.anathema.framework.itemdata.model.ItemData;
import net.sf.anathema.framework.module.preferences.PageSizePreference;
import net.sf.anathema.framework.reporting.ReportException;
import net.sf.anathema.framework.reporting.pdf.AbstractPdfReport;
import net.sf.anathema.framework.reporting.pdf.PageSize;
import net.sf.anathema.framework.repository.Item;
import net.sf.anathema.hero.framework.HeroEnvironment;
import net.sf.anathema.hero.model.Hero;
import net.sf.anathema.hero.sheet.pdf.content.ReportContentRegistry;
import net.sf.anathema.hero.sheet.pdf.encoder.boxes.EncoderRegistry;
import net.sf.anathema.hero.sheet.pdf.encoder.graphics.SheetGraphics;
import net.sf.anathema.hero.sheet.pdf.page.PageEncoder;
import net.sf.anathema.hero.sheet.pdf.page.PageRegistry;
import net.sf.anathema.hero.sheet.pdf.page.layout.Sheet;
import net.sf.anathema.hero.sheet.pdf.page.layout.landscape.FirstPageEncoder;
import net.sf.anathema.hero.sheet.pdf.page.layout.landscape.SecondPageEncoder;
import net.sf.anathema.hero.sheet.pdf.session.ReportSession;
import net.sf.anathema.lib.resources.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LandscapeExaltSheetReport extends AbstractPdfReport {
  private Resources resources;
  private PageSizePreference pageSizePreference;
  private final HeroReportingRegistries reportingModuleObject;

  public LandscapeExaltSheetReport(Resources resources, HeroEnvironment characterGenerics,
                                   PageSizePreference pageSizePreference) {
    this.resources = resources;
    this.pageSizePreference = pageSizePreference;
    this.reportingModuleObject = new HeroReportingRegistries(characterGenerics.getObjectFactory(), resources);
  }

  @Override
  public String toString() {
    return resources.getString("CharacterModule.Reporting.LandscapeSheet.Name");
  }

  @Override
  public void performPrint(Item item, Document document, PdfWriter writer) throws ReportException {
    PageSize pageSize = pageSizePreference.getPageSize();
    PdfContentByte directContent = writer.getDirectContent();
    try {
      ReportSession session = createSession(item);
      Sheet sheet = new Sheet(document, getEncoderRegistry(), resources, pageSize);
      for (PageEncoder encoder : collectPageEncoders(pageSize, session)) {
        SheetGraphics graphics = SheetGraphics.WithHelvetica(directContent);
        encoder.encode(sheet, graphics, session);
      }
    } catch (Exception e) {
      throw new ReportException(e);
    }
  }

  private ReportSession createSession(Item item) {
    Hero hero = (Hero) item.getItemData();
    return new ReportSession(getContentRegistry(), hero);
  }

  private List<PageEncoder> collectPageEncoders(PageSize pageSize, ReportSession session) {
    List<PageEncoder> encoderList = new ArrayList<>();
    encoderList.add(new FirstPageEncoder());
    encoderList.add(new SecondPageEncoder(getEncoderRegistry(), resources));
    Collections.addAll(encoderList, findAdditionalPages(pageSize, session));
    return encoderList;
  }

  private PageEncoder[] findAdditionalPages(PageSize pageSize, ReportSession session) {
    PageRegistry additionalPageRegistry = getReportingModuleObject().getAdditionalPageRegistry();
    return additionalPageRegistry.createEncoders(pageSize, getEncoderRegistry(), resources, session);
  }

  private EncoderRegistry getEncoderRegistry() {
    return getReportingModuleObject().getEncoderRegistry();
  }

  private HeroReportingRegistries getReportingModuleObject() {
    return reportingModuleObject;
  }

  private ReportContentRegistry getContentRegistry() {
    return getReportingModuleObject().getContentRegistry();
  }

  @Override
  public boolean supports(Item item) {
    if (item == null) {
      return false;
    }
    ItemData itemData = item.getItemData();
    if (!(itemData instanceof Hero)) {
      return false;
    }
    Hero hero = (Hero) itemData;
    return hero.getTemplate().getTemplateType().getCharacterType().isEssenceUser();
  }
}