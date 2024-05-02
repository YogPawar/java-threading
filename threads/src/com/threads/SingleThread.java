package com.threads;

public class SingleThread {

  public static void main(String[] args) {
    Thread tt = new Thread(() ->
        System.out.println("Inside the Thread"));

    tt.start();
    System.out.println("Not in Thread");

  }
}
