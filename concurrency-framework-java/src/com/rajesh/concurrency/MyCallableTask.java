package com.rajesh.concurrency;

import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyCallableTask implements Callable<String> {
	
	private String name;

	public MyCallableTask(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("* " + this.name + " Started ...");
		IntStream.of(1,2,3,4, 5)
					.boxed()
					.collect(Collectors.toList())
					.stream()
					.map(obj -> obj.toString())
					.map(s -> this.name + " : " + s)
					.forEach(DelayedPrint::printToConsole);
		System.out.println("* " + this.name + " Finished");
		return name;
	}

}
