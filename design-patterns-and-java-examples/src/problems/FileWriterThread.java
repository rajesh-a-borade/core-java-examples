package problems;

import java.util.List;

public class FileWriterThread extends Thread {

		private final List<Integer> taskQueue;
		private String name;
		
	   public FileWriterThread(String name, List<Integer> sharedQueue)
	   {
	      this.taskQueue = sharedQueue;
	      this.name = name;
	   }
	 
	   @Override
	   public void run()
	   {
	      while (true)
	      {
	         try
	         {
	            consume();
	         } catch (InterruptedException ex)
	         {
	            ex.printStackTrace();
	         }
	      }
	   }
	 
	   private void consume() throws InterruptedException
	   {
		  Thread.sleep(5000);
	      synchronized (taskQueue)
	      {
	         while (taskQueue.isEmpty())
	         {
	            System.out.println("*** " + this.name + " Queue is empty is waiting , size: " + taskQueue.size());
	            taskQueue.wait();
	         }
	         int i = (Integer) taskQueue.remove(0);
	         System.out.println("*** " + this.name + " Writing to file : " + i);
	         taskQueue.notifyAll();
	      }
	   }
}
