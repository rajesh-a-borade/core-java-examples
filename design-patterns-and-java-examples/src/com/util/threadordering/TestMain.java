package com.util.threadordering;

import java.util.ArrayList;

public class TestMain
{

    public static void main(String [] args)
    {
        int count=0;
        
        MyQueue<Thread> mQ = new MyQueue(new ArrayList<Thread>());        
        
        
        ThreadExecuter t1 = new ThreadExecuter(1, mQ);
        ThreadExecuter t2 = new ThreadExecuter(2, mQ);
        ThreadExecuter t3 = new ThreadExecuter(3, mQ);
        //ThreadExecuter t1 = new ThreadExecuter(count);
         
       mQ.enqueue(t1);
       mQ.enqueue(t2);
       mQ.enqueue(t3);
       
       t1.start();
       t2.start();
       t3.start();
      
        
       
    }
}

