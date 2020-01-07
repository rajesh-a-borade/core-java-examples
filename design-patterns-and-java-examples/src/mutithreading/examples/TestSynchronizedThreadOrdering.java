package mutithreading.examples;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class TestSynchronizedThreadOrdering
{

    public static void main(String [] args)
    {
        Object lock = new Object();
        
        Queue<Thread> queue = new ArrayBlockingQueue<>(3);
        SynchronizedCounterThread t1 = new SynchronizedCounterThread(1, lock, queue);
        SynchronizedCounterThread t2 = new SynchronizedCounterThread(2, lock, queue);
        SynchronizedCounterThread t3 = new SynchronizedCounterThread(3, lock, queue);        
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        t1.start();
        t2.start();
        t3.start();        
    }
}

