package net.sf.anathema.hero.framework.perspective.sheet;

import net.sf.anathema.framework.environment.SwingEnvironment;
import net.sf.anathema.framework.reporting.Report;
import net.sf.anathema.framework.reporting.ReportException;
import net.sf.anathema.framework.repository.Item;
import net.sf.anathema.framework.swing.MessageUtilities;
import net.sf.anathema.interaction.Command;
import net.sf.anathema.lib.io.PathUtils;
import net.sf.anathema.lib.message.Message;
import net.sf.anathema.lib.resources.Resources;
import org.apache.commons.io.IOUtils;

import javax.swing.JComponent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintCommand implements Command {

  public static final String PDF_EXTENSION = ".pdf";
  private final Resources resources;
  private final JComponent parent;
  private final Item item;
  private final Report report;
  private final FileChooser fileChooser;

  public PrintCommand(Resources resources, JComponent parent, Item item, Report report, FileChooser fileChooser) {
    this.resources = resources;
    this.parent = parent;
    this.item = item;
    this.report = report;
    this.fileChooser = fileChooser;
  }

  @Override
  public void execute() {
    try {
      Path selectedFile = fileChooser.getPrintFile();
      if (selectedFile == null) {
        return;
      }
      performPrint(item, report, selectedFile);
      openFile(selectedFile);
    } catch (FileNotFoundException e) {
      handleAlreadyOpenException(e);
    } catch (AccessDeniedException e) {
      handleForbiddenLocation(e);
    } catch (IOException e) {
      handleFailedToOpenException(e);
    } catch (Exception e) {
      handleGeneralException(e);
    }
  }

  private void showMessage(Throwable e, String errorMessageKey) {
    String errorMessage = resources.getString(errorMessageKey);
    MessageUtilities.indicateMessage(getClass(), parent, new Message(errorMessage, e));
  }

  private void performPrint(Item item, Report selectedReport, Path selectedFile) throws IOException, ReportException {
    OutputStream stream = null;
    try {
      stream = Files.newOutputStream(selectedFile);
      selectedReport.print(item, stream);
    } finally {
      IOUtils.closeQuietly(stream);
    }
  }

  private void openFile(Path selectedFile) throws IOException {
    if (SwingEnvironment.isAutoOpenSupported()) {
      PathUtils.openOnDesktop(selectedFile);
    }
  }

  private void handleForbiddenLocation(AccessDeniedException e) {
    showMessage(e, "Anathema.Reporting.Message.PrintError.ForbiddenLocation");
  }

  private void handleAlreadyOpenException(FileNotFoundException e) {
    showMessage(e, "Anathema.Reporting.Message.PrintError.FileOpen");
  }

  private void handleGeneralException(Exception e) {
    showMessage(e, "Anathema.Reporting.Message.PrintError");
  }

  private void handleFailedToOpenException(IOException e) {
    showMessage(e, "Anathema.Reporting.Message.NoApplication");
  }
}