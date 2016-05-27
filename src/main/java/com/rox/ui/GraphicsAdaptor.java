package com.rox.ui;

import java.awt.*;

/**
 * Implementation of {@Link com.rox.ui.CanvasAdaptor CanvasAdaptor}
 * for {@Link java.awt.Graphics Graphics}
 *
 * @Author rossdrew
 */
public class GraphicsAdaptor implements CanvasAdaptor {
    private final Graphics graphics;

    public GraphicsAdaptor(Graphics graphics){
        this.graphics = graphics;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        graphics.drawLine(x1,y1,x2,y2);
    }

    public void drawOval(int x1, int y1, int height, int width) {
        graphics.drawOval(x1,y1,width,height);
    }

    public void setColor(Color color) {
        graphics.setColor(color);
    }

    public Color getColor() {
        return graphics.getColor();
    }
}
