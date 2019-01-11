package com.github.pendext.image;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImagePixelCounterTest {

    private BufferedImage image;

    @BeforeEach
    public void setup() throws IOException {
        image = ImageIO.read(getClass().getResourceAsStream("/test_image.png"));
    }

    @Test
    public void imageUrlIsAsExpected() {

        String expectedUrl = RandomStringUtils.randomAlphabetic(10);
        ImagePixelCounter classUnderTest = new ImagePixelCounter(expectedUrl);

        assertThat(classUnderTest.countPixels(image).getUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void counterHasExpectedNumberOfPixels() {
        String expectedUrl = RandomStringUtils.randomAlphabetic(10);
        ImagePixelCounter classUnderTest = new ImagePixelCounter(expectedUrl);


        ImagePixelResult imagePixelResult = classUnderTest.countPixels(image);

        assertThat(imagePixelResult.getMostPrevalentColor()).isEqualTo("#0000ff");
        assertThat(imagePixelResult.getSecondMostPrevalentColor()).isEqualTo("#000000");
        assertThat(imagePixelResult.getThirdMostPrevalantColor()).isEqualTo("#ff0000");
    }

}
