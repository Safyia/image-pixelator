package com.github.pendext.image.file;

import java.io.*;

public class ImageFileOutputter {

    public ImageFileOutputter(String lineToAppend) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp/output.csv", true));
        bufferedWriter.write(lineToAppend);
        bufferedWriter.close();
    }

}
