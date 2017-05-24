package canvas;

import org.junit.*;

import exception.IllegalWidthORHeightException;

public class CanvasTest {

  @Test
  public void canvasIsCorrectlyCreated() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10, 10);
    Assert.assertEquals("Height must be 10", canvas.getHeight(), 10);
    Assert.assertEquals("Width must be 10", canvas.getWidth(), 10);
  }

  @Test
  public void newCanvasIsCorrectlyInitialized() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10, 10);
    char emptypoint = canvas.getEmptyPoint();
    Assert.assertEquals("Point should be empty", canvas.getPointAt(0, 0), emptypoint);
  }

  @Test
  public void drawPointIsSuccesfull() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10, 10);
    canvas.setFullPoint('X');

    canvas.drawPoint(0, 0);
    Assert.assertEquals("0,0 point should be full", canvas.getPointAt(0, 0), 'X');

    canvas.drawPoint(3, 3);
    Assert.assertEquals("3,3 point should be full", canvas.getPointAt(3, 3), 'X');

    canvas.drawPoint(7, 2);
    Assert.assertEquals("7,2 point should be full", canvas.getPointAt(7, 2), 'X');

    canvas.drawPoint(10, 9);
    Assert.assertNotEquals("10,9 point should be out of canvas", canvas.getPointAt(10, 9), 'X');
  }

  @Test
  public void fillIsWorkingProperly() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10, 10);
    canvas.setFullPoint('X');

    // top horizontal line
    canvas.drawPoint(4,3);

    // right vertical line
    canvas.drawPoint(5,3);
    canvas.drawPoint(5,4);
    canvas.drawPoint(5,5);
    canvas.drawPoint(5,6);
    canvas.drawPoint(5,7);

    // bottom horizontal line
    canvas.drawPoint(4,7);

    // left vertical line
    canvas.drawPoint(3,3);
    canvas.drawPoint(3,4);
    canvas.drawPoint(3,5);
    canvas.drawPoint(3,6);
    canvas.drawPoint(3,7);

    canvas.fill(4,4,'c');

    // check only internal of rectangle is colored
    Assert.assertEquals("4,4 is colored correctly", 'c', canvas.getPointAt(4,4));
    Assert.assertEquals("4,5 is colored correctly", 'c', canvas.getPointAt(4,5));
    Assert.assertEquals("4,6 is colored correctly", 'c', canvas.getPointAt(4,6));

    // check border of rectangle is not colored
    Assert.assertEquals("4,3 is border, thus not colored", 'X', canvas.getPointAt(4,3));
    Assert.assertEquals("4,7 is border, thus not colored", 'X', canvas.getPointAt(4,7));
  }
}
