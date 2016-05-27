package com.rox.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.awt.*;

/**
 * @Author rossdrew
 */
public class GraphicsAdaptorAndImageTest {
    private GraphicsAdaptor graphicsAdaptor;
    private Graphics graphics;

    @Before
    public void setup(){
        graphics = Mockito.mock(Graphics.class);
        graphicsAdaptor = new GraphicsAdaptor(graphics);
    }

    @Test
    public void testDrawLine(){
        CanvasImage image = new CanvasImage() {
            @Override
            public void draw() {
                canvasAdaptor.drawLine(startX,startY,endX,endY);
            }
        };
        image.setCanvasAdaptor(graphicsAdaptor);
        image.setLocation(1,1,10,10);

        image.draw();

        Mockito.verify(graphics).drawLine(1,1,11,11);
    }

    @Test
    public void testDrawOval(){
        CanvasImage image = new CanvasImage() {
            @Override
            public void draw() {
                canvasAdaptor.drawOval(startX, endX, 10, 10);
            }
        };
        image.setCanvasAdaptor(graphicsAdaptor);
        image.setLocation(1,1,20,20);

        image.draw();

        Mockito.verify(graphics).drawOval(1,21,10,10);
    }

    @Test
    public void testSetColor(){
        CanvasImage image = new CanvasImage() {
            @Override
            public void draw() {
                canvasAdaptor.setColor(Color.BLACK);
            }
        };
        image.setCanvasAdaptor(graphicsAdaptor);

        image.draw();

        Mockito.verify(graphics).setColor(Color.BLACK);
    }

    @Test
    public void testGetColor(){
        CanvasImage image = new CanvasImage() {
            @Override
            public void draw() {
                canvasAdaptor.getColor();
            }
        };
        image.setCanvasAdaptor(graphicsAdaptor);

        image.draw();

        Mockito.verify(graphics).getColor();
    }


}
