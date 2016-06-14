package com.rox.ui.com.rox.ui.logic.gate.binary;

import com.rox.ui.GraphicsAdaptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static junit.framework.TestCase.fail;

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
        canvas = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        canvasGraphics = canvas.createGraphics();
        graphicsAdaptor = new GraphicsAdaptor(canvasGraphics);

        image = new NotCanvasImage();
        image.setLocation(1,1,19,19);
        image.setCanvasAdaptor(graphicsAdaptor);
    }

    @Test
    public void testDraw() throws Exception {
        ByteArrayOutputStream beforeOutputStream = new ByteArrayOutputStream();
        ImageIO.write(canvas, "gif", beforeOutputStream);
        byte[] dataBefore = beforeOutputStream.toByteArray();
        System.out.println("Start MD5 Digest");
        MessageDigest mdB = MessageDigest.getInstance("MD5");
        mdB.update(dataBefore);
        byte[] hashBeforeDraw = mdB.digest();

        image.draw();

        ByteArrayOutputStream afterOutputStream = new ByteArrayOutputStream();
        ImageIO.write(canvas, "gif", afterOutputStream);
        byte[] dataAfter = afterOutputStream.toByteArray();
        System.out.println("Start MD5 Digest");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(dataAfter);
        byte[] hashAfterDraw = md.digest();

        System.out.println(returnHex(hashBeforeDraw)+"\n"+returnHex(hashAfterDraw));

        if (returnHex(hashBeforeDraw).compareTo(returnHex(hashAfterDraw)) == 0){
            System.out.println("Before and After hash values are the same");
        }

        System.out.println(Arrays.toString(dataBefore) + "\n" + Arrays.toString(dataAfter));

        for (int i=0; i < hashBeforeDraw.length; i++){
            if (hashAfterDraw[i] != hashBeforeDraw[i]) {
                fail();
            }
        }
        System.out.println("Before and after images have the same data");
        //TODO Get the hash compare working
        //fa0ebf4066e488671e01d39b7fe8bbcb
        //fa0ebf4066e488671e01d39b7fe8bbcb

    }

    // Below method of converting Byte Array to hex
    // Can be found at: http://www.rgagnon.com/javadetails/java-0596.html
    static String returnHex(byte[] inBytes) throws Exception {
        String hexString = "";
        for (int i=0; i < inBytes.length; i++) {
            hexString +=  Integer.toString( ( inBytes[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return hexString;
    }

    @After
    public void tearDown(){
        canvasGraphics.dispose();
    }
}
