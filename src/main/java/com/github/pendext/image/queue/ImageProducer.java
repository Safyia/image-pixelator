package com.github.pendext.image.queue;

import java.net.URL;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ImageProducer implements Runnable {

    private BlockingQueue<List<URL>> urlsQueue;
    private List<URL> urlsToProcess;

    public ImageProducer(BlockingQueue<List<URL>> urlsQueue, List<URL> urlsToProcess) {
        this.urlsQueue = urlsQueue;
        this.urlsToProcess = urlsToProcess;
    }

    @Override
    public void run() {
        try {
            urlsQueue.put(urlsToProcess);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong queueing images", e);
        }
    }

}
