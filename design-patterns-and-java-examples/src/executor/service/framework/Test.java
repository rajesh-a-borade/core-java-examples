package executor.service.framework;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyThread implements Runnable {

	private String name;
	private int sleepValue;
	
	public MyThread(String name, int sleepValue) {
		this.name = name;
		this.sleepValue = sleepValue;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(sleepValue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name + " - " + i);
		}	
			
	}
}

class CallableThread implements Callable<String> {

	private String name;
	private int sleepValue;
	
	public CallableThread(String name, int sleepValue) {
		this.name = name;
		this.sleepValue = sleepValue;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
	
	@Override
	public String call() {
		for(int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(sleepValue);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(this.name.equals("Two")) {
				if(i == 2) {
					return "FAILED";
				}
			}
			
			System.out.println(this.name + " - " + i);
		}	
		return "FINISH";	
	}
	
}


public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/*
		// ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(new MyThread("One", 1000));
		executorService.submit(new MyThread("Two", 500));
		executorService.shutdown();
		*/
		//---------------
		// ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		ExecutorService executorService = Executors.newScheduledThreadPool(10); //.newSingleThreadExecutor();//newFixedThreadPool(1);
										
		Set<Callable<String>> callables = new TreeSet<Callable<String>>();
		callables.add(new CallableThread("One", 1000));
		callables.add(new CallableThread("Two", 500));
		List<Future<String>> futures = executorService.invokeAll(callables);
		
		Iterator<Callable<String>> callableIterator = callables.iterator();
		Iterator<Future<String>> futureIterator = futures.iterator();
		
		System.out.println("Callable iterator size " + callables.size());
		System.out.println("Future iterator size " + futures.size());
		
		while(futureIterator.hasNext()) {
			System.out.println("callable name= " + callableIterator.next().toString());
			System.out.println("future value= " + futureIterator.next().get());
		}
		
		executorService.shutdown();
				
	}
}
