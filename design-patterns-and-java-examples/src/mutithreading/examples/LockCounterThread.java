package mutithreading.examples;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class LockCounterThread
    extends SynchronizedCounterThread
{

    private Lock lock;
    
    public LockCounterThread(int thread_id, Lock lock, Queue<Thread> queue)
    {
        super(thread_id, lock, queue);
        this.lock = lock;
    }
    
    @Override
    public void run()
    {
        System.out.println(this.toString() + " started ...");
        while(true) {
            System.out.println(this.toString() + " running ...");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            lock.lock();
            {
                // System.out.println(this.toString() + " has the lock ...");
                Thread t = this.getQueue().peek();
                // if this thread is at the top of the queue
                if(t.getId() == this.getId()) {
                    this.getQueue().remove();
                    Printer.getPrinter().print(this.getId(), this.getCount());
                    this.incrementCount();
                    this.getQueue().add(t);
                }
                // System.out.println(this.toString() + " releasing the lock...");
            }
            lock.unlock();
        }
    }
}

