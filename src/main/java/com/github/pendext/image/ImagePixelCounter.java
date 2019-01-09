package com.github.pendext.image;


import java.io.File;

public class ImagePixelCounter {

    private String url;

    public ImagePixelCounter(String url) {
        this.url = url;
    }

    public ImagePixelResult countPixels(File image) {
        ImagePixelResult imagePixelResult = new ImagePixelResult();
        imagePixelResult.setUrl(url);

        return imagePixelResult;
    }

}
