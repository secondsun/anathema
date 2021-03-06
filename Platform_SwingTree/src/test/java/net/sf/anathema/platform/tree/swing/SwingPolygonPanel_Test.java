package net.sf.anathema.platform.tree.swing;

import net.sf.anathema.framework.ui.Coordinate;
import net.sf.anathema.platform.tree.display.AgnosticPolygonPanel;
import net.sf.anathema.platform.tree.view.draw.Canvas;
import net.sf.anathema.platform.tree.view.draw.FilledPolygon;
import net.sf.anathema.platform.tree.view.draw.FlexibleArrow;
import net.sf.anathema.platform.tree.view.draw.InteractiveGraphicsElement;
import net.sf.anathema.platform.tree.view.draw.PolygonMother;
import net.sf.anathema.platform.tree.view.interaction.Closure;
import org.junit.Before;
import org.junit.Test;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class SwingPolygonPanel_Test {

  private final SwingPolygonPanel swingPanel = new SwingPolygonPanel();
  private final AgnosticPolygonPanel polygonPanel = new AgnosticPolygonPanel(swingPanel);
  private final Graphics2D graphics = mock(Graphics2D.class);
  private final Canvas canvas = new SwingGraphicsCanvas(graphics);

  @Before
  public void setUp() throws Exception {
    when(graphics.create()).thenReturn(graphics);
    swingPanel.setSize(100, 100);
  }

  @Test
  public void hasIdentityTransformationInitially() throws Exception {
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(new AffineTransform());
  }

  @Test
  public void allowsZoomOutTo30Percent() throws Exception {
    double factor = 0.3;
    polygonPanel.scale(factor);
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getScaleInstance(factor, factor));
  }

  @Test
  public void limitsZoomOutTo30Percent() throws Exception {
    double factor = 0.29;
    polygonPanel.scale(factor);
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getScaleInstance(1, 1));
  }

  @Test
  public void allowsZoomInTo150Percent() throws Exception {
    double factor = 1.50;
    polygonPanel.scale(factor);
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getScaleInstance(1.5, 1.5));
  }

  @Test
  public void limitsZoomInTo150Percent() throws Exception {
    double factor = 1.51;
    polygonPanel.scale(factor);
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getScaleInstance(1, 1));
  }


  @Test
  public void scalesToAGivenPoint() throws Exception {
    double factor = .50;
    polygonPanel.scaleToPoint(factor, new Coordinate(100, 100));
    swingPanel.paintComponent(graphics);
    AffineTransform expected = new AffineTransform(0.5, 0, 0, 0.5, 0, 0);
    verify(graphics).transform(expected);
  }

  @Test
  public void translatesGraphics() throws Exception {
    polygonPanel.translate(5, 7);
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getTranslateInstance(5, 7));
  }

  @Test
  public void translatesZoomedGraphicsRelativeToScale() throws Exception {
    double factor = 1.50;
    polygonPanel.scale(factor);
    polygonPanel.translateRelativeToScale(150, 150);
    swingPanel.paintComponent(graphics);
    AffineTransform expected = new AffineTransform(1.5, 0, 0, 1.5, 100, 100);
    verify(graphics).transform(expected);
  }

  @Test
  public void centersOnPoint() throws Exception {
    polygonPanel.centerOn(new Coordinate(10, 10));
    swingPanel.paintComponent(graphics);
    verify(graphics).transform(AffineTransform.getTranslateInstance(40, 40));
  }

  @Test
  public void activatesAntiAliasing() throws Exception {
    swingPanel.paintComponent(graphics);
    verify(graphics).setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
  }

  @Test
  public void paintsPolygon() throws Exception {
    InteractiveGraphicsElement polygon = mock(FilledPolygon.class);
    polygonPanel.add(polygon);
    swingPanel.paintComponent(graphics);
    verify(polygon).paint(canvas);
  }

  @Test
  public void paintsArrow() throws Exception {
    FlexibleArrow arrow = mock(FlexibleArrow.class);
    polygonPanel.add(arrow);
    swingPanel.paintComponent(graphics);
    verify(arrow).paint(canvas);
  }

  @Test
  public void paintsAllPolygon() throws Exception {
    InteractiveGraphicsElement firstPolygon = mock(FilledPolygon.class);
    InteractiveGraphicsElement secondPolygon = mock(FilledPolygon.class);
    polygonPanel.add(firstPolygon);
    polygonPanel.add(secondPolygon);
    swingPanel.paintComponent(graphics);
    verify(firstPolygon).paint(canvas);
    verify(secondPolygon).paint(canvas);
  }

  @Test
  public void hasNoElementsAfterClear() throws Exception {
    InteractiveGraphicsElement element = mock(FilledPolygon.class);
    polygonPanel.add(element);
    polygonPanel.clear();
    swingPanel.paintComponent(graphics);
    verifyZeroInteractions(element);
  }
}