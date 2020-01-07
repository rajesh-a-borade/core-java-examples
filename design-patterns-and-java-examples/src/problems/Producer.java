package problems;

import java.util.List;

public class Producer extends Thread {

	private String name;
	private int queue_capacity;
	private final List<Integer> unsortedQueue;
	
	public Producer(String name, List<Integer> unsortedQueue, int queue_capacity) {
		this.name = name;
		this.unsortedQueue = unsortedQueue;
		this.queue_capacity = queue_capacity;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void produce() throws InterruptedException
	   {
	      synchronized (unsortedQueue)
	      {
	         while (unsortedQueue.size() == queue_capacity)
	         {
	            System.out.println("*** " + this.name + " Queue is full is waiting , size: " + unsortedQueue.size());
	            unsortedQueue.wait();
	         }
	         List<Integer> list = RandomUtils.getRandomNumbersList(10, 1, 100);
	         for(Integer current : list) {
	        	 Thread.sleep(500);
	        	 unsortedQueue.add(current);
	        	 System.out.println("*** " + this.name + " Added to Queue : " + current);
	         }
	         unsortedQueue.notifyAll();
	      }
	   }
}
