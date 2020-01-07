package mutithreading.examples;

import java.util.Queue;

public class SynchronizedCounterThread
    extends Thread
{

    private int id;
    private int count;
    private Object lock;
    private Queue<Thread> queue;
    
    public SynchronizedCounterThread(int thread_id, Object lock, Queue<Thread> queue)
    {
        this.count = 1;
        this.id = thread_id;
        this.lock = lock;
        this.queue = queue;
    }
    
    @Override
    public long getId()
    {
        return this.id;
    }
    
    protected Queue<Thread> getQueue() {
        return this.queue;
    }
    
    protected int getCount()
    {
        return count;
    }
    
    protected int incrementCount()
    {
        return count++   ;
    }
    
    @Override
    public String toString()
    {
        return "Thread[" + this.id + "]";
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
            synchronized (this.lock) {
                // System.out.println(this.toString() + " has the lock ...");
                Thread t = this.queue.peek();
                // if this thread is at the top of the queue
                if(t.getId() == this.getId()) {
                    this.getQueue().remove();
                    Printer.getPrinter().print(this.getId(), this.getCount());
                    this.incrementCount();
                    this.getQueue().add(t);
                }
                // System.out.println(this.toString() + " releasing the lock...");
            }
        }
    }
}

