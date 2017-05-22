package elements;

import canvas.Canvas;

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

  public void draw(Canvas canvas) {
    canvas.setFullPoint(this.fullPoint);

    int minHeight = this.y1 < this.y2 ? this.y1 : this.y2;
    int maxHeight = this.y1 > this.y2 ? this.y1 : this.y2;
    int minWidth = this.x1 < this.x2 ? this.x1 : this.x2;
    int maxWidth = this.x1 > this.x2 ? this.x1 : this.x2;

    for (int r = minHeight; r <= maxHeight; r++) {
      for (int c = minWidth; c <= maxWidth; c++) {
        canvas.drawPoint(r, c);
      }
    }
  }

  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }
}
