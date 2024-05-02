package com.threads;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    String destFieTwo = "T:\\java-threading\\threads\\e";
    String destFieOne = "T:\\java-threading\\threads\\f";

    //  new Thread(new CopyTask(sourceFileOne, destFieOne)).start();

    //  new Thread(new CopyTask(sourceFilesTwo, destFieTwo)).start();

    //Using ExecutorService
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.execute(new CopyTask(sourceFileOne, destFieOne));
    executorService.execute(new CopyTask(sourceFilesTwo, destFieTwo));

  }
}
