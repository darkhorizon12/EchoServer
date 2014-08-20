package com.rr.echoserver;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Threader<T> extends Thread {
  private BlockingQueue<T> queue = new LinkedBlockingQueue<T>();

  @Override
  public void run() {
    queue.add(getValue());
  }

  public abstract T getValue();

  public T executeOnDifferentThread() throws InterruptedException {
    this.start();
    return queue.take();
  }

  public T executeOnSameThread() throws InterruptedException {
    this.run();
    return queue.take();
  }
}
