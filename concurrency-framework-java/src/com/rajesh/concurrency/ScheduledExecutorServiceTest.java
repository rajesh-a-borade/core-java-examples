package com.rajesh.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		// ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
		executorService.scheduleAtFixedRate(new MyRunnableTask("AtFixedRate"), 5L, 5L, TimeUnit.SECONDS);
		executorService.scheduleWithFixedDelay(new MyRunnableTask("WithFixedDelay"), 5L, 5L, TimeUnit.SECONDS);
		executorService.schedule(new MyCallableTask("ScheduledTask1"), 1, TimeUnit.SECONDS);
		executorService.schedule(new MyCallableTask("ScheduledTask2"), 1, TimeUnit.SECONDS);
		executorService.awaitTermination(60, TimeUnit.SECONDS);
	}
}
