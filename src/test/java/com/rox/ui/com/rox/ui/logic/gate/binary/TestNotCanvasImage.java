package com.rox.ui.com.rox.ui.logic.gate.binary;

import com.rox.ui.GraphicsAdaptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Arrays;

/**
 * @Author rossdrew
 * @Created 27/05/16.
 */
public class TestNotCanvasImage {
    private BufferedImage canvas;
    private Graphics canvasGraphics;
    private NotCanvasImage image;
    private GraphicsAdaptor graphicsAdaptor;

    @Before
    public void setUp(){
        canvas = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
        canvasGraphics = canvas.createGraphics();
        graphicsAdaptor = new GraphicsAdaptor(canvasGraphics);

        image = new NotCanvasImage();
        image.setLocation(1,1,19,19);
        image.setCanvasAdaptor(graphicsAdaptor);
    }

    @Test
    public void testDraw(){
        image.draw();

        //TODO Hash the image and compare it?

        Raster r = canvas.getData();
        int[] data = new int[100*100];
        int[] linearData = new int[100*100];
        int i = 0;
        for (int x=0; x<100; x++){
            for (int y=0; y<100; y++){
                linearData[i++] = canvas.getRGB(x,y);
            }
        }
        System.out.println(Arrays.toString(linearData));//Doesn't seem to be right
    }

    @After
    public void tearDown(){
        canvasGraphics.dispose();
    }
}
