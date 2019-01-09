package com.github.pendext.image;

public class ImagePixelResult {
    private String url;
    private String mostPrevalentColor;
    private String secondMostPrevalentColor;
    private String thirdMostPrevalantColor;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMostPrevalentColor() {
        return mostPrevalentColor;
    }

    public void setMostPrevalentColor(String mostPrevalentColor) {
        this.mostPrevalentColor = mostPrevalentColor;
    }

    public String getSecondMostPrevalentColor() {
        return secondMostPrevalentColor;
    }

    public void setSecondMostPrevalentColor(String secondMostPrevalentColor) {
        this.secondMostPrevalentColor = secondMostPrevalentColor;
    }

    public String getThirdMostPrevalantColor() {
        return thirdMostPrevalantColor;
    }

    public void setThirdMostPrevalantColor(String thirdMostPrevalantColor) {
        this.thirdMostPrevalantColor = thirdMostPrevalantColor;
    }

}
