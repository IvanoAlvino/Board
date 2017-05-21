package canvas;

public class Canvas {

  private char[][] canvas;

  private boolean[][] consideredPoints;

  private int width;

  private int height;

  private char fullPoint;

  private char emptyPoint;

  public Canvas(int width, int height) {
    this.width = width;
    this.height = height;
    this.canvas = new char[this.width][this.height];
    this.consideredPoints = new boolean[this.width][this.height];
    fullPoint = 'x';
    emptyPoint = '.';
    clearCanvas();
  }

  private void clearCanvas() {
    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        this.canvas[x][y] = emptyPoint;
      }
    }
  }

  public void drawPoint(int x, int y) {
    if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
      this.canvas[x][y] = this.fullPoint;
    }
  }

  public void fill(int x, int y, Object color) {
    initConsideredPoints();
    recursiveFill(x, y, color);
  }

  private void initConsideredPoints() {
    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        this.consideredPoints[x][y] = false;
      }
    }
  }

  private void recursiveFill(int x, int y, Object color) {
    if (outOfBorder(x, y) || this.canvas[x][y] == this.fullPoint || alreadyConsidered(x, y)) {
      return;
    }

    this.canvas[x][y] = (Character) color;
    this.consideredPoints[x][y] = true;
    recursiveFill(x - 1, y, color); // up
    recursiveFill(x + 1, y, color); // right
    recursiveFill(x, y - 1, color); // down
    recursiveFill(x, y + 1, color); // left
  }

  private boolean outOfBorder(int x, int y) {
    return x < 0 || x >= this.width || y < 0 || y >= this.height;
  }

  private boolean alreadyConsidered(int x, int y) {
    return this.consideredPoints[x][y];
  }

  public void printToStdout() {
    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        System.out.print(this.canvas[x][y]);
      }
      System.out.println();
    }
  }

  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }
}
