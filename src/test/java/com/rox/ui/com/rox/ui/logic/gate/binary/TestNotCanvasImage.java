package com.rox.ui.com.rox.ui.logic.gate.binary;

import com.rox.ui.GraphicsAdaptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @Author rossdrew
 */
@RunWith(MockitoJUnitRunner.class)
public class TestNotCanvasImage {
    private NotCanvasImage image;
    private GraphicsAdaptor graphicsAdaptor;

    @Mock
    private Graphics2D graphicsMock;

    @Before
    public void setUp(){
        graphicsAdaptor = new GraphicsAdaptor(graphicsMock);

        image = new NotCanvasImage();
        image.setLocation(1,1,19,19);
        image.setCanvasAdaptor(graphicsAdaptor);
    }

    @Test
    public void testDraw() throws Exception {
        //XXX I'd like to test the actual drawing of the image
        //    - attempted to try create a hash of the created image and
        //      compare to example hash but couldn't get it working
        when(graphicsMock.getColor()).thenReturn(Color.BLACK);
        image.draw();

        verify(graphicsMock).drawLine(1, 1, 1, 20);
        verify(graphicsMock).drawLine(1, 1, 20, 10);
        verify(graphicsMock).drawLine(1, 20, 20, 10);

        verify(graphicsMock).drawOval(20, 9, 3, 3);

        verify(graphicsMock, times(2)).setColor(Color.BLACK);
    }

    @After
    public void tearDown(){
        graphicsMock.dispose();
    }
}
