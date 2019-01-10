package com.github.pendext.image;

public class MaxColorSet {

    private final String mostPrevalent;
    private final String secondMostPrevalent;
    private final String thirdMostPrevalent;


    public MaxColorSet(String mostPrevalent, String secondMostPrevalent, String thirdMostPrevalent) {
        this.mostPrevalent = mostPrevalent;
        this.secondMostPrevalent = secondMostPrevalent;
        this.thirdMostPrevalent = thirdMostPrevalent;
    }

    public String getFirstMostPrevalent() {
        return mostPrevalent;
    }

    public String getSecondMostPrevalent() {
        return secondMostPrevalent;
    }

    public String getThirdMostPrevalent() {
        return thirdMostPrevalent;
    }
}
