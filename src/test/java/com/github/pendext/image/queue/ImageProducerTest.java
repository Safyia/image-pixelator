package com.github.pendext.image.queue;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class ImageProducerTest {


    @Test
    public void runInvokesExpectedMethodsToPushUrlsToQueue() throws Exception {
        BlockingQueue<List<URL>> urlsQueue = new LinkedBlockingQueue<>();
        List<URL> urlsToProcess = new ArrayList<>();
        URL expectedUrl = new URL("http://www.example.com");
        urlsToProcess.add(expectedUrl);
        new ImageProducer(urlsQueue, urlsToProcess).run();
        assertThat(urlsQueue.size()).isEqualTo(1);
        assertThat(urlsQueue.take().get(0)).isEqualTo(expectedUrl);
    }

}