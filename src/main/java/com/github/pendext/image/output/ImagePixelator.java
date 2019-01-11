package com.github.pendext.image.output;

import com.github.pendext.image.queue.*;
import org.apache.commons.io.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ImagePixelator {

    private static final int FILE_BATCH_SIZE = 8040000;

    public static void main(String[] args) throws IOException {
        System.out.println("Beginning process to determine image pixels");
        URL input = ImagePixelator.class.getResource("/input.txt");
        File file = new File(input.getFile());

        LineIterator iterator = FileUtils.lineIterator(file, "UTF-8");
        BlockingQueue<List<URL>> queue = new LinkedBlockingQueue<>();
        int fileSizes = 0;
        List<URL> urlsToProcess = new ArrayList<>();

        try {
            while (iterator.hasNext()) {
                String currentUrl = iterator.next();
                URL imageUrl = new URL(currentUrl);
                urlsToProcess.add(imageUrl);

                URLConnection urlConnection = imageUrl.openConnection();
                int contentLength = urlConnection.getContentLength();
                fileSizes += contentLength;

                if (fileSizes > FILE_BATCH_SIZE) {
                    System.out.println("urls to process size: " + urlsToProcess.size());
                    new ImageProducer(queue, urlsToProcess).run();
                    new ImageConsumer(queue).run();
                    urlsToProcess.clear();
                    fileSizes = 0;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong pixeling images", e);
        }

        System.out.println("Completed process to determine image pixels");
    }

}
