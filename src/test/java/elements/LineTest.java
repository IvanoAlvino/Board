package elements;

import canvas.Canvas;
import exception.IllegalWidthORHeightException;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {

  @Test
  public void lineIsCorrectlyDrawed() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10,10);
    Line line = new Line(1, 1, 1, 5);
    line.setFullPoint('x');
    line.draw(canvas);

    char linePoint = 'x';
    Assert.assertEquals("Point 1,1 should be filled by line", canvas.getPointAt(0,0), linePoint);
    Assert.assertEquals("Point 2,1 should be filled by line", canvas.getPointAt(1,0), linePoint);
    Assert.assertEquals("Point 3,1 should be filled by line", canvas.getPointAt(2,0), linePoint);
    Assert.assertEquals("Point 4,1 should be filled by line", canvas.getPointAt(3,0), linePoint);
    Assert.assertEquals("Point 5,1 should be filled by line", canvas.getPointAt(4,0), linePoint);
    Assert.assertNotEquals("Point 6,1 should be empty", canvas.getPointAt(0,6), linePoint);
  }

  @Test
  public void negativePointsLineIsNotDrawed() throws IllegalWidthORHeightException {
    Canvas canvas = new Canvas(10, 10);
    Line line = new Line(-1, -7, -1, -20);
    line.setFullPoint('x');
    canvas.setEmptyPoint(' ');
    line.draw(canvas);

    for (int r = 0; r < canvas.getHeight(); r++) {
      for (int c = 0; c < canvas.getWidth(); c++) {
        Assert.assertEquals("Point " + r + "," + c + " must be empty", ' ', canvas.getPointAt(r,c));
      }
    }
  }
}
