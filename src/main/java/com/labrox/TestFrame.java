package com.labrox;

import com.rox.ui.CanvasAdaptor;
import com.rox.ui.CanvasImage;
import com.rox.ui.GraphicsAdaptor;
import com.rox.ui.com.rox.ui.logic.gate.binary.NotCanvasImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.security.NoSuchAlgorithmException;

/**
 * @Author rossdrew
 * @Created 30/05/16.
 */
public class TestFrame extends JFrame implements ComponentListener {
    public TestFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setVisible(true);

        addComponentListener(this);

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
        TestFrame frame = new TestFrame();
    }

    public void componentResized(ComponentEvent e) {
        System.out.println("componentResized");
        
        repaint();
    }

    public void componentMoved(ComponentEvent e) {
        System.out.println("componentMoved");
    }

    public void componentShown(ComponentEvent e) {
        System.out.println("componentShown");
    }

    public void componentHidden(ComponentEvent e) {
        System.out.println("componentHidden");
    }
}
