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
    this.canvas = new char[this.height][this.width];
    this.consideredPoints = new boolean[this.height][this.width];
    fullPoint = 'x';
    emptyPoint = ' ';
    clearCanvas();
    printToStdout();
  }

  private void clearCanvas() {
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
        this.canvas[r][c] = emptyPoint;
      }
    }
  }

  public void drawPoint(int r, int c) {
    if (r >= 0 && r < this.height && c >= 0 && c < this.width) {
      this.canvas[r][c] = this.fullPoint;
    }
  }

  public void fill(int x, int y, Object color) {
    initConsideredPoints();
    recursiveFill(x, y, color);
  }

  private void initConsideredPoints() {
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
        this.consideredPoints[r][c] = false;
      }
    }
  }

  private void recursiveFill(int r, int c, Object color) {
    if (outOfBorder(r, c) || this.canvas[r][c] == this.fullPoint || alreadyConsidered(r, c)) {
      return;
    }

    this.canvas[r][c] = (Character) color;
    this.consideredPoints[r][c] = true;
    recursiveFill(r - 1, c, color); // up
    recursiveFill(r + 1, c, color); // right
    recursiveFill(r, c - 1, color); // down
    recursiveFill(r, c + 1, color); // left
  }

  private boolean outOfBorder(int r, int c) {
    return r < 0 || r >= this.height || c < 0 || c >= this.width;
  }

  private boolean alreadyConsidered(int r, int c) {
    return this.consideredPoints[r][c];
  }

  public void printToStdout() {
    printLineBorder();

    System.out.println();
    for (int r = 0; r < this.height; r++) {
      System.out.print("|");
      for (int c = 0; c < this.width; c++) {
        System.out.print(this.canvas[r][c]);
      }
      System.out.print("|");
      System.out.println();
    }

    printLineBorder();
    System.out.println();
  }

  private void printLineBorder() {
    for (int c = 0; c < this.width + 2; c++) {
      System.out.print("-");
    }
  }

  public void setFullPoint(char fullPoint) {
    this.fullPoint = fullPoint;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public char getEmptyPoint() {
    return emptyPoint;
  }

  public char getPointAt(int r, int c) {
    if (!outOfBorder(r, c)) {
      return this.canvas[r][c];
    }
    return '/';
  }

  public char getFullpoint() {
    return this.fullPoint;
  }
}
