import canvas.Canvas;
import elements.Line;
import elements.Rectangle;
import exception.IllegalWidthORHeightException;
import exception.PointsNotInOrderException;

import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  private static Canvas canvas;

  public static void main(String[] args) {
    printMenu();
    manageInput();
  }

  /**
   * Print the command line menu.
   */
  private static void printMenu() {
    System.out.println("Canvas: C width height");
    System.out.println("Line: L x1 y1 x2 y2");
    System.out.println("Rectangle: R x1 y1 x2 y2");
    System.out.println("Bucket: B x y charColor");
    System.out.println("Exit: Q");
    System.out.println();
  }

  /**
   * Create a {@link Canvas}.
   */
  private static void createCanvas() {
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    try {
      canvas = new Canvas(width, height);
    }
    catch (IllegalWidthORHeightException e) {
      System.out.println(e.getMessage());
      System.out.println("Canvas has not been created.");
    }
  }

  /**
   * Read the operators from command line and call selected procedures.
   */
  private static void manageInput() {
    while (true) {
      System.out.print("Command: ");

      switch (readOneChar()) {
        case 'C':
          createCanvas();
          break;
        case 'L':
          if (canvasHasBeenCreated()) {
            drawLine();
          }
          break;
        case 'R':
          if (canvasHasBeenCreated()) {
            drawRectangle();
          }
          break;
        case 'B':
          if (canvasHasBeenCreated()) {
            bucketFill();
          }
          break;
        case 'Q':
          return;
      }
    }
  }

  /**
   * Crate a {@link Line} and draw it.
   */
  private static void drawLine() {
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    new Line(x1, y1, x2, y2).draw(canvas);
    canvas.printToStdout();
  }

  /**
   * Create a {@link Rectangle} and draw it.
   */
  private static void drawRectangle() {
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();

    Rectangle rectangle;
    try {
      rectangle = new Rectangle(x1, y1, x2, y2);
      rectangle.draw(canvas);
      canvas.printToStdout();
    }
    catch (PointsNotInOrderException e) {
      System.out.println(e.getMessage());
      System.out.println("Rectangle has not been printed.");
    }
  }

  /**
   * Perform bucketFill.
   * The input is checked against the canvas size, if it is not correct the bucketFill will not be performed.
   */
  private static void bucketFill() {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    char color = readOneChar();
    if (x > 0 && y > 0 && x <= canvas.getWidth() && y <= canvas.getHeight()) {
      canvas.fill(x - 1, y - 1, color);
      canvas.printToStdout();
    }
    else {
      System.out.println("Provided x and y are exceeding canvas size.");
    }
  }

  /**
   * Check if the canvas has already been created.
   * @return true if canvas exists, false otherwise
   */
  private static boolean canvasHasBeenCreated() {
    if (canvas == null) {
      System.out.println("First create a canvas");
      return false;
    }
    return true;
  }

  /**
   * Read one single char from the stdin.
   * If more than one char is inserted, just return the first one.
   * @return The first char from the stdin.
   */
  private static char readOneChar() {
    return scanner.next().charAt(0);
  }

}
