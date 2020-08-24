package org.baymax.interview.second.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 展示 引用队列 何时有值, AOP 的 后置通知
 *
 * 被回收时 放在引用队列中保存一下
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/14 14:18
 */
public class ReferenceQueueDemo {
  public static void main(String[] args) {


    Object o1 = new Object();


    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

    WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);


    System.out.println(o1);
    System.out.println(weakReference.get()); // 如果是虚引用，则 get() 也是 null
    System.out.println(referenceQueue.poll());

    System.out.println("===================");


    // 这个不能忘记
    o1 = null;

    System.gc();

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(o1);
    System.out.println(weakReference.get());
    System.out.println(referenceQueue.poll());
    System.out.println(referenceQueue.poll().get());




  }
}
