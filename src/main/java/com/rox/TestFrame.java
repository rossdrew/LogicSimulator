package com.rox;

import com.rox.ui.CanvasAdaptor;
import com.rox.ui.CanvasImage;
import com.rox.ui.GraphicsAdaptor;
import com.rox.ui.com.rox.ui.logic.gate.binary.NotCanvasImage;

import javax.swing.*;
import java.awt.*;
import java.security.NoSuchAlgorithmException;

/**
 * @Author rossdrew
 * @Created 30/05/16.
 */
public class TestFrame extends JFrame {
    public TestFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);
        add(new JPanel(){
            private CanvasAdaptor adaptor;

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (adaptor == null)
                    adaptor = new GraphicsAdaptor(g);

                CanvasImage canvasImage = new NotCanvasImage();
                canvasImage.setCanvasAdaptor(adaptor);
                canvasImage.setLocation(1,1,100,100);
                canvasImage.draw();
            }
        });
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {


// convert hash bytes to string (usually in hexadecimal form)

        TestFrame frame = new TestFrame();
    }
}
