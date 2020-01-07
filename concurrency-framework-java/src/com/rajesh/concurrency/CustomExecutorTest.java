package com.rajesh.concurrency;

import java.util.concurrent.Executor;

public class CustomExecutorTest {

	public static void main(String[] args) {
		
		System.out.println("Main Started...");
		
		MyExecutor myExecutor = new MyExecutor();
		myExecutor.execute(new MyRunnableTask("Stupid task"));
		
		System.out.println("Main Finished");
	}
}

class MyExecutor implements Executor {
	
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}