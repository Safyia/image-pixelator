package com.github.pendext.image.queue;

import com.github.pendext.image.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ImageConsumer implements Runnable {

    private BlockingQueue<List<URL>> queue;

    public ImageConsumer(BlockingQueue<List<URL>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            List<URL> urlList = queue.take();
            urlList.parallelStream().forEach( imageUrl -> {
                try {
                    BufferedImage bufferedImage = ImageIO.read(imageUrl);
                    ImagePixelCounter imagePixelCounter = new ImagePixelCounter(imageUrl.toString());
                    ImagePixelResult imagePixelResult = imagePixelCounter.countPixels(bufferedImage);
                    System.out.println(imagePixelResult.toString());
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

