package canvas;

import org.junit.*;

public class CanvasTest {

  @Test
  public void canvasIsCorrectlyCreated() {
    Canvas canvas = new Canvas(10, 10);
    Assert.assertEquals("Height must be 10", canvas.getHeight(), 10);
    Assert.assertEquals("Width must be 10",canvas.getWidth(), 10);
  }

  @Test
  public void newCanvasIsCorrectlyInitialized() {
    Canvas canvas = new Canvas(10, 10);
    char emptypoint = canvas.getEmptyPoint();
    Assert.assertEquals("Point should be empty", canvas.getPointAt(0, 0), emptypoint);
  }

  @Test
  public void drawPointIsSuccesfull() {
    Canvas canvas = new Canvas(10, 10);
    canvas.setFullPoint('X');
    canvas.drawPoint(0, 0);
    Assert.assertEquals("point should be full", canvas.getPointAt(0, 0), 'X');
  }
}
