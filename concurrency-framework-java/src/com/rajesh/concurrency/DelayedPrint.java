package com.rajesh.concurrency;

import java.util.concurrent.TimeUnit;

public interface DelayedPrint {
	
	public static void printToConsole(Object obj) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(obj);
	}
}
