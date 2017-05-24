package elements;

import org.junit.Assert;
import org.junit.Test;

import canvas.Canvas;
import exception.IllegalWidthORHeightException;
import exception.PointsNotInOrderException;

public class RectangleTest {

  @Test
  public void rectangleIsCorrectlydrawed() throws IllegalWidthORHeightException, PointsNotInOrderException {
    Canvas canvas = new Canvas(10,10);
    Rectangle rectangle = new Rectangle(1,1, 6,6);
    rectangle.setFullPoint('x');
    rectangle.draw(canvas);

    char rectanglePoint = 'x';
    // Check horizontal top line
    Assert.assertEquals("Point 1,1 should be filled by line", canvas.getPointAt(0,0), rectanglePoint);
    Assert.assertEquals("Point 2,1 should be filled by line", canvas.getPointAt(1,0), rectanglePoint);
    Assert.assertEquals("Point 3,1 should be filled by line", canvas.getPointAt(2,0), rectanglePoint);
    Assert.assertEquals("Point 4,1 should be filled by line", canvas.getPointAt(3,0), rectanglePoint);
    Assert.assertEquals("Point 5,1 should be filled by line", canvas.getPointAt(4,0), rectanglePoint);
    Assert.assertEquals("Point 6,1 should be filled by line", canvas.getPointAt(5,0), rectanglePoint);

    // Check right vertical line
    Assert.assertEquals("Point 6,2 should be filled by line", canvas.getPointAt(5,1), rectanglePoint);
    Assert.assertEquals("Point 6,3 should be filled by line", canvas.getPointAt(5,2), rectanglePoint);
    Assert.assertEquals("Point 6,4 should be filled by line", canvas.getPointAt(5,3), rectanglePoint);
    Assert.assertEquals("Point 6,5 should be filled by line", canvas.getPointAt(5,4), rectanglePoint);

    // Check horizontal bottom line
    Assert.assertEquals("Point 1,6 should be filled by line", canvas.getPointAt(0,5), rectanglePoint);
    Assert.assertEquals("Point 2,6 should be filled by line", canvas.getPointAt(1,5), rectanglePoint);
    Assert.assertEquals("Point 3,6 should be filled by line", canvas.getPointAt(2,5), rectanglePoint);
    Assert.assertEquals("Point 4,6 should be filled by line", canvas.getPointAt(3,5), rectanglePoint);
    Assert.assertEquals("Point 5,6 should be filled by line", canvas.getPointAt(4,5), rectanglePoint);
    Assert.assertEquals("Point 6,6 should be filled by line", canvas.getPointAt(5,5), rectanglePoint);

    // Check left vertical line
    Assert.assertEquals("Point 1,2 should be filled by line", canvas.getPointAt(0,1), rectanglePoint);
    Assert.assertEquals("Point 1,3 should be filled by line", canvas.getPointAt(0,2), rectanglePoint);
    Assert.assertEquals("Point 1,4 should be filled by line", canvas.getPointAt(0,3), rectanglePoint);
    Assert.assertEquals("Point 1,5 should be filled by line", canvas.getPointAt(0,4), rectanglePoint);
  }

}
