package com.github.pendext.image;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.*;

class MaxColorsDeterminatorTest {

    private String mostPrevalent = "#gggggg";
    private String secondMostPrevalent = "#bbbbbb";
    private String thirdMostPrevalent = "#ffb333";
    private String other1 = "#123456";
    private String other2 = "#987654";

    private List<String> colorsToDetermine;

    private MaxColorsDeterminator maxColorsDeterminator;

    @BeforeEach
    public void setup() {
        colorsToDetermine = buiildTestColorDistribution();

        maxColorsDeterminator = new MaxColorsDeterminator();
    }

    @Test
    public void determineReturnsExpectedTopThreeColorsForBasicList() {
        MaxColorSet maxColorSet = maxColorsDeterminator.determine(colorsToDetermine);
        assertThat(maxColorSet.getFirstMostPrevalent()).isEqualTo(mostPrevalent);
        assertThat(maxColorSet.getSecondMostPrevalent()).isEqualTo(secondMostPrevalent);
        assertThat(maxColorSet.getThirdMostPrevalent()).isEqualTo(thirdMostPrevalent);
    }

    private List<String> buiildTestColorDistribution() {
        List<String> colorsToDetermine = new ArrayList<>();

        colorsToDetermine.add(other1);
        colorsToDetermine.add(other1);

        for (int i = 0; i < 30; i++) {
            colorsToDetermine.add(secondMostPrevalent);
        }

        colorsToDetermine.add(other1);

        for (int i = 0; i < 307; i++) {
            colorsToDetermine.add(mostPrevalent);
        }

        colorsToDetermine.add(other2);
        colorsToDetermine.add(other2);
        colorsToDetermine.add(other2);
        colorsToDetermine.add(other2);

        for (int i = 0; i < 25; i++) {
            colorsToDetermine.add(thirdMostPrevalent);
        }

        colorsToDetermine.add(other1);

        return colorsToDetermine;
    }

}