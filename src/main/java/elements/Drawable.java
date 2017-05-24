package elements;

import canvas.Canvas;

public interface Drawable {

  /**
   * Draw the element in the provided canvas.
   * @param canvas The canvas where to draw the element
   */
  void draw(Canvas canvas);

}
