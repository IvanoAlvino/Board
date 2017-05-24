package elements;

import canvas.Canvas;
import exception.PointsNotInOrderException;

/**
 * Holds two points representing a Rectangle.
 * The first point is the top left point, where the second one is the bottom right point.
 * Input verification is done at Constructor level.
 */
public class Rectangle implements Drawable {

  private int x1;

  private int y1;

  private int x2;

  private int y2;

  private char fullPoint;

  /**
   * Creates a Rectangle given the top left and bottom right points.
   * If the given points are not in the correct order and format, thorws an exception.
   *
   * @param x1 Top left width coordinate
   * @param y1 Top left height coordinate
   * @param x2 Bottom right width coordinate
   * @param y2 Bottom right height coordinate
   *
   * @throws PointsNotInOrderException if the given points are not in correct order
   */
  public Rectangle(int x1, int y1, int x2, int y2) throws PointsNotInOrderException {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.fullPoint = 'x';

    if (!pointsAreInCorrectOrder()) {
      throw new PointsNotInOrderException(
          "Points are not in correct order.First point should be upper left, second point bottom right");
    }
  }

  /**
   * Check if the given points are in correct order, i.e. x1,y1 must be top left and x2,y2 bottom right.
   * @return true if given points satisfy constraints
   */
  private boolean pointsAreInCorrectOrder() {
    return this.x2 > this.x1 && this.y2 > this.y1;
  }

  /**
   * Draw the elemen in the given canvas.
   * @param canvas The canvas where to draw the element
   */
  public void draw(Canvas canvas) {
    canvas.setFullPoint(this.fullPoint);

    new Line(this.x1, this.y1, this.x2, this.y1).draw(canvas); // top horizontal
    new Line(this.x2, this.y1, this.x2, this.y2).draw(canvas); // right vertical
    new Line(this.x1, this.y2, this.x2, this.y2).draw(canvas); // bottom horizontal
    new Line(this.x1, this.y1, this.x1, this.y2).draw(canvas); // left vertical

  }

  /**
   * Set the char point used to draw the Rectangle in the {@link Canvas}
   * @param fullPoint the char value to be used.
   */
  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }
}
