package com.github.pendext.image;


import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ImagePixelCounter {

    private String url;

    public ImagePixelCounter(String url) {
        this.url = url;
    }

    public ImagePixelResult countPixels(BufferedImage image) {
        ImagePixelResult imagePixelResult = new ImagePixelResult();
        imagePixelResult.setUrl(url);


        Map<String, Integer> colorCountMap = new HashMap<>();

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                String hexValue = "#" + Integer.toHexString(pixel).substring(2);
                if (!colorCountMap.containsKey(hexValue)) {
                    colorCountMap.put(hexValue, 1);
                } else {
                    Integer incrementedCount = colorCountMap.get(hexValue) + 1;
                    colorCountMap.put(hexValue, incrementedCount);
                }
            }
        }

        List<String> topThreeColors = colorCountMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .map(Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());

        imagePixelResult.setMostPrevalentColor(topThreeColors.get(0));
        imagePixelResult.setSecondMostPrevalentColor(topThreeColors.get(1));
        imagePixelResult.setThirdMostPrevalantColor(topThreeColors.get(2));

        return imagePixelResult;
    }

}
