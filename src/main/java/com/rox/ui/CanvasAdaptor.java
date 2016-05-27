package com.rox.ui;

import java.awt.*;

/**
 * Implementation independent canvas
 *
 * @Author rossdrew
 */
public interface CanvasAdaptor {
    void drawLine(int x1, int y1, int x2, int y2);
    void drawOval(int x1, int y1, int height, int width);
    void setColor(Color color);
    Color getColor();
}
