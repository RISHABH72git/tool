package com.example.tool.service;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateDifferentFile {

    public void createPdf() throws IOException {
        PDDocument newPdf = new PDDocument();
        newPdf.addPage(new PDPage());
        //save pdf
        newPdf.save("/home/priyansh77/Documents/Sample.pdf");
        System.out.println("PDF created");
        newPdf.close();
    }

    public void captureScreen() throws AWTException, IOException {
        System.setProperty("java.awt.headless", "false");
        Robot robot = new Robot();
        BufferedImage screeShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        for (int i = 100; i < 200; i++) {
            File file = new File(i+"secondScreenshot.png");
            ImageIO.write(screeShot, "png", file);
        }

    }

}
