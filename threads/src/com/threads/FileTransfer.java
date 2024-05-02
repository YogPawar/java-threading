package com.threads;

import java.io.IOException;

class CopyTask implements Runnable {

  String sourceFile;
  String destinationFile;

  CopyTask(String sourceFile, String destinationFile) {
    this.sourceFile = sourceFile;
    this.destinationFile = destinationFile;
  }

  @Override
  public void run() {
    try {
      IOUtils.copyFile(sourceFile, destinationFile);
      System.out.println("File Copied From :" + sourceFile + " To : " + destinationFile);
    } catch (IOException ioException) {

    }
  }
}

public class FileTransfer {

  public static void main(String[] args) throws IOException {
    String sourceFileOne = "T:\\java-threading\\threads\\a";
    String sourceFilesTwo = "T:\\java-threading\\threads\\b";

    String destFieTwo = "T:\\java-threading\\threads\\d";
    String destFieOne = "T:\\java-threading\\threads\\c";

    Thread t1 = new Thread(new CopyTask(sourceFileOne, destFieOne));
    t1.start();

    Thread t2 = new Thread(new CopyTask(sourceFilesTwo, destFieTwo));
    t2.start();

  }
}
