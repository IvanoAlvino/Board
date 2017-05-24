package elements;

import canvas.Canvas;

/**
 * Vertical or horizontal line.
 * No input verification is done at Constructor level, but only vertical or horizontal line will be drawn
 * when {@link Line#draw(Canvas)} is called.
 */
public class Line implements Drawable {

  private int x1;

  private int y1;

  private int x2;

  private int y2;

  private char fullPoint;

  public Line(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.fullPoint = 'x';
  }

  /**
   * Draw a line between two points x1,y1 and x2,y2.
   * Only horizontal and vertical Line are allowed, if x1, y1 are not vertical or horizontal no line is drawn.
   * Switching the values from x1,y2 to x2,y2 will lead to same result.
   *
   * @param canvas The canvas where to draw the element
   */
  public void draw(Canvas canvas) {
    canvas.setFullPoint(this.fullPoint);

    int minHeight = this.y1 < this.y2 ? this.y1 : this.y2;
    int maxHeight = this.y1 > this.y2 ? this.y1 : this.y2;
    int minWidth = this.x1 < this.x2 ? this.x1 : this.x2;
    int maxWidth = this.x1 > this.x2 ? this.x1 : this.x2;

    if (minHeight == maxHeight) {
      for (int c = minWidth; c <= maxWidth; c++) {
        canvas.drawPoint(minHeight - 1, c - 1);
      }
    } else if (minWidth == maxWidth) {
      for (int r = minHeight; r <= maxHeight; r++) {
        canvas.drawPoint(r - 1, minWidth - 1);
      }
    }

  }

  /**
   * Set the point that will be used to draw the line in the {@link Canvas}.
   * @param fullPoint The char value to be used
   */
  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }
}
