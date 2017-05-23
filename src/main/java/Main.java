import canvas.Canvas;
import elements.Line;
import elements.Rectangle;

import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  private static Canvas canvas;

  public static void main(String[] args) {
    printMenu();
    manageInput();
  }

  private static void printMenu() {
    System.out.println("Canvas: C width height");
    System.out.println("Line: L x1 y1 x2 y2");
    System.out.println("Rectangle: L x1 y1 x2 y2");
    System.out.println("Bucket: B x y ");
    System.out.println("Exit: Q");
    System.out.println();
  }

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

  private static boolean canvasHasBeenCreated() {
    if (canvas == null) {
      System.out.println("First create a canvas");
      return false;
    }
    return true;
  }

  private static void bucketFill() {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    char color = readOneChar();
    canvas.fill(x - 1, y - 1, color);
    canvas.printToStdout();
  }

  private static void drawRectangle() {
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    new Rectangle(x1, y1, x2, y2).draw(canvas);
    canvas.printToStdout();
  }

  private static void createCanvas() {
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    canvas = new Canvas(width, height);
  }

  private static char readOneChar() {
    return scanner.next(".").charAt(0);
  }

  private static void drawLine() {
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    new Line(x1, y1, x2, y2).draw(canvas);
    canvas.printToStdout();
  }

}
