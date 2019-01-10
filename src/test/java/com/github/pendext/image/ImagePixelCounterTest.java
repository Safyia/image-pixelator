package com.github.pendext.image;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class ImagePixelCounterTest {

    private BufferedImage image;

    @Mock
    MaxColorsDeterminator maxColorsDeterminator;

    @BeforeEach
    public void setup() throws IOException {
        image = ImageIO.read(getClass().getResourceAsStream("/test_image.png"));
    }

    @Test
    public void imageUrlIsAsExpected() {
        when(maxColorsDeterminator.determine(any())).thenReturn(new MaxColorSet(null, null, null));

        String expectedUrl = RandomStringUtils.randomAlphabetic(10);
        ImagePixelCounter classUnderTest = new ImagePixelCounter(expectedUrl, maxColorsDeterminator);

        assertThat(classUnderTest.countPixels(image).getUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void counterHasExpectedNumberOfPixels() {
        String expectedUrl = RandomStringUtils.randomAlphabetic(10);
        ImagePixelCounter classUnderTest = new ImagePixelCounter(expectedUrl, maxColorsDeterminator);

        String expectedMostPrevalent = "#aaaaaa";
        String expectedSecondMostPrevalent = "#bbb123";
        String expectedThirdMostPrevalent = "#333777";

        MaxColorSet maxColorSet = new MaxColorSet(expectedMostPrevalent, expectedSecondMostPrevalent, expectedThirdMostPrevalent);

        when(maxColorsDeterminator.determine(any())).thenReturn(maxColorSet);

        ImagePixelResult imagePixelResult = classUnderTest.countPixels(image);

        assertThat(imagePixelResult.getMostPrevalentColor()).isEqualTo(expectedMostPrevalent);
        assertThat(imagePixelResult.getSecondMostPrevalentColor()).isEqualTo(expectedSecondMostPrevalent);
        assertThat(imagePixelResult.getThirdMostPrevalantColor()).isEqualTo(expectedThirdMostPrevalent);
    }

}
