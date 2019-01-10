package com.github.pendext.image;


import java.awt.image.BufferedImage;
import java.util.*;

public class ImagePixelCounter {

    private String url;
    private MaxColorsDeterminator maxColorsDeterminator;

    public ImagePixelCounter(String url, MaxColorsDeterminator maxColorsDeterminator) {
        this.url = url;
        this.maxColorsDeterminator = maxColorsDeterminator;
    }

    public ImagePixelResult countPixels(BufferedImage image) {
        ImagePixelResult imagePixelResult = new ImagePixelResult();
        imagePixelResult.setUrl(url);

        List<String> hexValuesInImage = new ArrayList<>();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                String hexValue = "#" + Integer.toHexString(pixel).substring(2);
                hexValuesInImage.add(hexValue);
            }
        }

        MaxColorSet maxColorSet = maxColorsDeterminator.determine(hexValuesInImage);
        imagePixelResult.setMostPrevalentColor(maxColorSet.getFirstMostPrevalent());
        imagePixelResult.setSecondMostPrevalentColor(maxColorSet.getSecondMostPrevalent());
        imagePixelResult.setThirdMostPrevalantColor(maxColorSet.getThirdMostPrevalent());

        return imagePixelResult;
    }

}
