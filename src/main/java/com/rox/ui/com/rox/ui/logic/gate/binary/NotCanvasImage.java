package com.rox.ui.com.rox.ui.logic.gate.binary;

import com.rox.ui.CanvasImage;

import java.awt.*;

/**
 * @Author rossdrew
 */
public class NotCanvasImage extends CanvasImage {
    @Override
    public void draw() {
        int trianglePoint = endY / 2;
        int notCircleSize = (endY - startY) / 5;
        int notCircleLocation = trianglePoint-(notCircleSize/2);

        Color c = canvasAdaptor.getColor();
        canvasAdaptor.setColor(Color.black);

        canvasAdaptor.drawLine(startX, startY, startX, endY);
        canvasAdaptor.drawLine(startX, startY, endX, trianglePoint);
        canvasAdaptor.drawLine(startX, endY, endX, trianglePoint);
        canvasAdaptor.drawOval(endX, notCircleLocation, notCircleSize, notCircleSize);

        canvasAdaptor.setColor(c);
    }
}
