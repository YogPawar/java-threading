package com.threads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

  public static void copy(InputStream src, OutputStream des) throws IOException {
    int value;
    while ((value = src.read()) != -1) {
      des.write(value);
    }

  }

  public static void copyFile(String sourceFile, String destinationFile)
      throws IOException {
    FileInputStream fin = new FileInputStream(sourceFile);
    FileOutputStream fos = new FileOutputStream(destinationFile);
    IOUtils.copy(fin, fos);
    System.out.println("File Copy Done");
    fin.close();
    fos.close();
  }

}
