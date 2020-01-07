package com.util.threadordering;

import problems.RandomUtils;


public class ThreadExecuter
    extends Thread
{
    private int id;
    private int count = 1;
    // Lock lock;
    MyQueue<Thread> mQ;

    public ThreadExecuter(int id, MyQueue<Thread> mQ)
    {
        this.id = id;
        this.mQ = mQ;
    }

    @Override
    public void run()
    {

        while (true)
        {
            // System.out.println("Thread "+this.id+" running...");
            try
            {
                Thread.sleep(RandomUtils.generateRandom(1, 10)*1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized (mQ)
            {
                // System.out.println(this.id+","+mQ.peek().getId());
                if (this.id == mQ.peek().getId())
                {
                    Printer.getInstance().print("Thread " + this.id + " : " + count + "");
                    this.count++;
                    mQ.dequeue();
                    mQ.enqueue(this);
                }

            }

        }

    }

    @Override
    public long getId()
    {
        // TODO Auto-generated method stub
        return this.id;
    }

}
