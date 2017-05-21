package elements;

import canvas.Canvas;
import org.junit.Assert;
import org.junit.Test;

public class LineTest {

  @Test
  public void lineIsCorrectlyDrawed() {
    Canvas canvas = new Canvas(10,10);
    Line line = new Line(0, 0, 0, 5);
    line.draw(canvas);
    char linePoint = 'X';
    Assert.assertEquals("Point 0,0 should be filled by line", canvas.getPointAt(0,0), linePoint);
    Assert.assertEquals("Point 0,1 should be filled by line", canvas.getPointAt(0,1), linePoint);
    Assert.assertEquals("Point 0,2 should be filled by line", canvas.getPointAt(0,2), linePoint);
    Assert.assertEquals("Point 0,3 should be filled by line", canvas.getPointAt(0,3), linePoint);
    Assert.assertEquals("Point 0,4 should be filled by line", canvas.getPointAt(0,4), linePoint);
    Assert.assertEquals("Point 0,5 should be filled by line", canvas.getPointAt(0,5), linePoint);
    Assert.assertNotEquals("Point 0,6 should be empty", canvas.getPointAt(0,6), linePoint);
  }
}
