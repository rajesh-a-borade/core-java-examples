package com.rajesh.concurrency;

public class MyRunnableTask implements Runnable {
	
	private String name;

	public MyRunnableTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("* " + this.name + " Started ...");
		// TODO
		System.out.println("* " + this.name + " Finished");
	}
}
