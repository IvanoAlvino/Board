package elements;

import canvas.Canvas;

public class Rectangle implements Drawable {

  private int x1;

  private int y1;

  private int x2;

  private int y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public void draw(Canvas canvas) {
    for (int x = this.x1; x < this.x2; x++) {
      for (int y = this.y1; y < this.y2; y++) {
        canvas.drawPoint(x, y);
      }
    }
  }
}
