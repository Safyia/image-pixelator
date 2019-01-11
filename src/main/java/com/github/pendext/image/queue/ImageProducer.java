package com.github.pendext.image.queue;

import java.net.URL;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ImageProducer implements Runnable {

    private BlockingQueue<List<URL>> urls;
    private List<URL> urlsToProcess;

    public ImageProducer(BlockingQueue<List<URL>> urls, List<URL> urlsToProcess) {
        this.urls = urls;
        this.urlsToProcess = urlsToProcess;
    }

    @Override
    public void run() {
        try {
            urls.put(urlsToProcess);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
