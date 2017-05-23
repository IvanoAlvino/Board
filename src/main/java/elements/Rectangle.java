package elements;

import canvas.Canvas;

public class Rectangle implements Drawable {

  private int x1;

  private int y1;

  private int x2;

  private int y2;

  private char fullPoint;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.fullPoint = 'x';
  }

  public void draw(Canvas canvas) {
    canvas.setFullPoint(this.fullPoint);

    new Line(this.x1, this.y1, this.x2, this.y1).draw(canvas); // top horizontal
    new Line(this.x2, this.y1, this.x2, this.y2).draw(canvas); // right vertical
    new Line(this.x1, this.y2, this.x2, this.y2).draw(canvas); // bottom horizontal
    new Line(this.x1, this.y1, this.x1, this.y2).draw(canvas); // left vertical

  }

  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }
}
