package com.rox.ui;

/**
 * An image which can be drawn to our implementation
 * independent {@Link com.rox.ui.CanvasAdaptor CanvasAdaptor}
 *
 * @Author rossdrew
 */
public abstract class CanvasImage {
    protected CanvasAdaptor canvasAdaptor;

    protected int startX, startY, endX, endY;

    public void setCanvasAdaptor(CanvasAdaptor canvasAdaptor){
        this.canvasAdaptor = canvasAdaptor;
    }

    public void setLocation(int x, int y, int xSize, int ySize){
        startX = x;
        startY = y;
        endX = startX + xSize;
        endY = startY + ySize;
    }

    public abstract void draw();
}