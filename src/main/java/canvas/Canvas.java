package canvas;

import exception.IllegalWidthORHeightException;

public class Canvas {

  private char[][] canvas;

  private int width;

  private int height;

  /**
   * The char representing a full point in the canvas.
   */
  private char fullPoint;

  /**
   * The char representing an empty point in the canvas.
   */
  private char emptyPoint;

  /**
   * Support data used to keep track of point already considered when performing {@link Canvas#fill(int, int, Object)}
   */
  private boolean[][] consideredPoints;

  public Canvas(int width, int height) throws IllegalWidthORHeightException {
    if (width <= 0 || height <= 0) {
      throw new IllegalWidthORHeightException("Canvas can not be created with zero or negative width or height.");
    }

    this.width = width;
    this.height = height;
    this.canvas = new char[this.height][this.width];
    this.consideredPoints = new boolean[this.height][this.width];
    fullPoint = 'x';
    emptyPoint = ' ';
    clearCanvas();
    printToStdout();
  }

  /**
   * Initialize every point in the canvas using {@link Canvas#emptyPoint}.
   */
  private void clearCanvas() {
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
        this.canvas[r][c] = emptyPoint;
      }
    }
  }

  /**
   * Insert {@link Canvas#fullPoint} in point r, c
   *
   * @param r width coordinate
   * @param c height coordinate
   */
  public void drawPoint(int r, int c) {
    if (r >= 0 && r < this.height && c >= 0 && c < this.width) {
      this.canvas[r][c] = this.fullPoint;
    }
  }

  /**
   * Perform a bucket paint-like fill in the canvas, starting from r,c coordinates and filling with @param color all
   * contiguous empty points.
   * This will stop once every empty canvas points in the area starting from r,c are filled with the chosen color.
   *
   * @param r     width coordinate
   * @param c     height coordinate
   * @param color the color to use
   */
  public void fill(int r, int c, Object color) {
    initConsideredPoints();
    recursiveFill(r, c, color);
  }

  /**
   * Initialize a boolean matrix to use as support to track already considered points when performing
   * {@link Canvas#fill(int, int, Object)}.
   */
  private void initConsideredPoints() {
    for (int r = 0; r < this.height; r++) {
      for (int c = 0; c < this.width; c++) {
        this.consideredPoints[r][c] = false;
      }
    }
  }

  /**
   * Perform a recursive algorithm to fill avery not already considered empty points starting from r,c with @param color
   *
   * @param r width coordinate
   * @param c height coordinate
   * @param color the color to use
   */
  private void recursiveFill(int r, int c, Object color) {
    if (outOfBorder(r, c) || this.canvas[r][c] == this.fullPoint || alreadyConsidered(r, c)) {
      return;
    }

    this.canvas[r][c] = (Character)color;
    this.consideredPoints[r][c] = true;
    recursiveFill(r - 1, c, color); // up
    recursiveFill(r + 1, c, color); // right
    recursiveFill(r, c - 1, color); // down
    recursiveFill(r, c + 1, color); // left
  }

  /**
   * Check if provided r, c are out of border
   * @param r width coordinate
   * @param c height coordinate
   * @return true if r,c is out of canvas
   */
  private boolean outOfBorder(int r, int c) {
    return r < 0 || r >= this.height || c < 0 || c >= this.width;
  }

  private boolean alreadyConsidered(int r, int c) {
    return this.consideredPoints[r][c];
  }

  /**
   * Print the canvas to stdout.
   * Canvas is printed inside a border.
   */
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

  public void setEmptyPoint(char emptyPoint) {
    this.emptyPoint = emptyPoint;
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

  /**
   * Get point in canvas at coordinates r,c
   * @param r width coordinate
   * @param c height coordinate
   * @return the point
   */
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
