package com.util.threadordering;

import java.util.List;
import java.util.ArrayList;

public class MyQueue<T>
{
    private List<T> queue = new ArrayList<T>();  
    
    MyQueue(List<Integer> queue){
        this.queue = (List<T>)queue;
    }
    

    public List<T> getQueue()
    {
        return queue;
    }


    public void setQueue(List<T> queue)
    {
        this.queue = queue;
    }


    public T dequeue()
    {
        if(queue.size()==0) {
            System.out.println("Queue is empty");
            return null;
            
        }else {
            T temp = queue.get(0);
            queue.remove(temp);
            return (T)temp;
            
        }
        
    }
    
    public int getsize() {
        return queue.size();
    }
    
    public  void enqueue(T i)
    {        
        queue.add(i);      
    }


    @Override
    public String toString()
    {
        return "MyQueue [queue=" + queue + "]";
    }
    
    public T peek() {
        return queue.get(0);
    }
    
    
 
    
}