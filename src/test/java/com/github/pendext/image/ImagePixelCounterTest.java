package com.github.pendext.image;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class ImagePixelCounterTest {

    @Test
    public void testSomeLibraryMethod() {
        String expectedUrl = RandomStringUtils.randomAlphabetic(10);

        ImagePixelCounter classUnderTest = new ImagePixelCounter(expectedUrl);

        assertThat(classUnderTest.countPixels(null).getUrl()).isEqualTo(expectedUrl);
    }

}
