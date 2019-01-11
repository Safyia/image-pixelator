package com.github.pendext.image.output;

import com.github.pendext.image.queue.*;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ImagePixelator {

    public static void main(String[] args) throws IOException {
        System.out.println("Beginning process to determine image pixels");
        URL input = ImagePixelator.class.getResource("/input.txt");
        File file = new File(input.getFile());

        List<String> urls = FileUtils.readLines(file, "UTF-8");

        BlockingQueue<List<URL>> queue = new LinkedBlockingQueue<>();

        int fileSizes = 0;
        List<URL> urlsToProcess = new ArrayList<>();
        for (String url : urls) {
            try {
                URL imageUrl = new URL(url);
                urlsToProcess.add(imageUrl);

                URLConnection urlConnection = imageUrl.openConnection();
                int contentLength = urlConnection.getContentLength();
                fileSizes += contentLength;

                if (fileSizes > 20000000) {
                    System.out.println("urls to process size: " + urlsToProcess.size());
                    new ImageProducer(queue, urlsToProcess).run();
                    new ImageConsumer(queue).run();
                    urlsToProcess.clear();
                    fileSizes = 0;
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Completed process to determine image pixels");
    }

}
