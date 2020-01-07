package problems;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Consumer extends Thread {

	private String name;
	private List<Integer> unsortedQueue;
	private List<Integer> sortedQueue;
	
	public Consumer(String name, List<Integer> unsortedQueue, List<Integer> sortedQueue) {
		this.name = name;
		this.unsortedQueue = unsortedQueue;
		this.sortedQueue = sortedQueue;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void consume() throws InterruptedException
	   {
	      synchronized (unsortedQueue)
	      {
	         while (unsortedQueue.isEmpty()) {
	        	System.out.println("*** " + this.name + " Unsorted Queue is empty is waiting , size: " + unsortedQueue.size());
	            unsortedQueue.wait();
	         }
	         // while(!unsortedQueue.isEmpty()) 
	         {
	        	 Thread.sleep(500);
		         int _value = (Integer) unsortedQueue.remove(0);
		         System.out.println("*** " + this.name + " Consumed: " + _value);
		         _putToSortedQueue(_value);
	         }
	         unsortedQueue.notify();
	      }
	   }
	
	private void _putToSortedQueue(int _value) {
		System.out.println("*** " + this.name + " putting to sorted Queue: " + _value);
		synchronized (sortedQueue) {
			Set<Integer> _internalOrderedSet = new TreeSet<>();
			_internalOrderedSet.addAll(sortedQueue);
			_internalOrderedSet.add(_value);
			while(!sortedQueue.isEmpty()) {
				sortedQueue.remove(0);
			}
			System.out.println("*** " + this.name + " _internalOrderedSet : " + _internalOrderedSet);
			sortedQueue.addAll(_internalOrderedSet);
			System.out.println("*** " + this.name + " Sorted Queue: " + sortedQueue);
			sortedQueue.notifyAll();
		}
	}
}
