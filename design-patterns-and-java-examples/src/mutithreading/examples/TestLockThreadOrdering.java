package mutithreading.examples;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockThreadOrdering
{

    public static void main(String [] args)
    {
        Lock lock = new ReentrantLock();
        Queue<Thread> queue = new ArrayBlockingQueue<>(3);
        LockCounterThread t1 = new LockCounterThread(1, lock, queue);
        LockCounterThread t2 = new LockCounterThread(2, lock, queue);
        LockCounterThread t3 = new LockCounterThread(3, lock, queue);        
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        t1.start();
        t2.start();
        t3.start();        
    }
}

