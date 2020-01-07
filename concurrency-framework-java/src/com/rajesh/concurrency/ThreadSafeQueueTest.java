package com.rajesh.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

class ConsumerThread extends Thread {

	private BlockingQueue<Integer> queue;
	
	public ConsumerThread(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		
		while(true) {
			while(queue.isEmpty());
			DelayedPrint.printToConsole("Consume - " + queue.poll());
		}
	}
	
}

public class ThreadSafeQueueTest {

	
	public static void main(String[] args) throws Exception{
		
		// BlockingQueue<Integer> boundedQueue = new ArrayBlockingQueue<>(3); 
		// BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(); // unbounded
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2); // bounded
		new ConsumerThread(blockingQueue).start();
		
		IntStream stream = IntStream.range(1, 10); 
		stream
			.boxed()
			.forEach(e -> {
				try {
					System.out.println("Put - " + e);
					blockingQueue.put(e);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			});
		System.out.println();
		System.out.println("--------------MAIN thread EXIT----------");
		System.out.println();
	}
}
