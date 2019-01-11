package com.github.pendext.image;



import static org.assertj.core.api.Java6Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

class ImagePixelResultTest {

    @Test
    public void toStringCreatesExpectedLine() {
        String expectedUrl = RandomStringUtils.randomAlphabetic(3);
        String expectedFirstString = RandomStringUtils.randomAlphabetic(3);
        String expectedSecondString = RandomStringUtils.randomAlphabetic(3);
        String expectedThirdString = RandomStringUtils.randomAlphabetic(3);

        ImagePixelResult result = new ImagePixelResult();
        result.setUrl(expectedUrl);
        result.setMostPrevalentColor(expectedFirstString);
        result.setSecondMostPrevalentColor(expectedSecondString);
        result.setThirdMostPrevalantColor(expectedThirdString);

        assertThat(result.toString()).isEqualTo(expectedUrl + ", " + expectedFirstString + ", " + expectedSecondString + ", " + expectedThirdString + "\n");
    }
    
}