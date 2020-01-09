package com.rajesh.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCompletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> "World");
		 
		String parallelExample = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .collect(Collectors.joining(" "));
		System.out.println("parallelExample = " + parallelExample);
		System.out.println();
		
		CompletableFuture<String> combineExample 
		  = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCombine(CompletableFuture.supplyAsync(
		      () -> " World"), (s1, s2) -> { return s1 + s2; });
		System.out.println("combineExample = " + combineExample.get());
		System.out.println();
		
		CompletableFuture<Order> completableFutureExample1 
			= CompletableFuture.supplyAsync(Order::getOrder)
							.thenApply(order -> order.setStatus("PAYMENT_DONE").returnOrder())
							.exceptionally(OrderProcessingExceptionHandler::apply)
							.thenApply(order -> order.setStatus("SHIPPED").returnOrder())
							.exceptionally(OrderProcessingExceptionHandler::apply)
							.thenApply(order -> order.setStatus("COMPLETE").returnOrder())
							.exceptionally(OrderProcessingExceptionHandler::apply);
	
		System.out.println("completableFutureExample1 status " + completableFutureExample1.get().toString());
		System.out.println();
		
		ExecutorService generalExecutorService = Executors.newFixedThreadPool(2);
		ExecutorService paymentExecutorService = Executors.newFixedThreadPool(2);
		
		CompletableFuture.supplyAsync(Order::getOrder)
								.thenApplyAsync(order -> order.setStatus("PAYMENT_DONE").returnOrder(), paymentExecutorService)
								.exceptionally(OrderProcessingExceptionHandler::apply)
								.thenApplyAsync(order -> order.setStatus("SHIPPED").returnOrder(), generalExecutorService)
								.exceptionally(OrderProcessingExceptionHandler::apply)
								.thenApplyAsync(order -> order.setStatus("COMPLETE").returnOrder(), generalExecutorService)
								.exceptionally(OrderProcessingExceptionHandler::apply)
								.whenComplete((order, e) -> { 
																generalExecutorService.shutdownNow();
																paymentExecutorService.shutdownNow(); 
															})
								.thenAccept(System.out::println);
		
		System.out.println();
		
		// runAsync return the Void type
		CompletableFuture<Void> c = CompletableFuture
		        .runAsync(() -> System.out.println("runAsync"))
		        .thenRunAsync(() -> System.out.println("thenRunAsync"));
		
		// thenCompose returns flattened future
		// thenApply() is used when the previous stage returns a pure value not a CompletionStage.
		// thenCompose() is used when the previous stage returns a CompletionStage.
		
		// thenXXXAsync are run on the different executor (default is Common ForkJoin Pool) 
		
		System.out.println("--------------MAIN thread EXIT----------");
		System.out.println();
	}
	
}

interface OrderProcessingExceptionHandler{

	public static Order apply(Throwable t) {
		System.err.println("... handling error by OrderProcessingExceptionHandler");
		return new Order("ERROR");
	}
	
}

class Order {
	
	private long id;
	private String status;
	
	public Order() {
	}
	
	public Order(String status) {
		super();
		this.id = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
		this.status = status;
	}

	public Order returnOrder() {
		return this;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public Order setStatus(String status) {
		this.status = status;
		try {
			int randomWait = ThreadLocalRandom.current().nextInt(1, 7);
			System.out.println("... " + status + " taking approx " + randomWait + " seconds ");
			if(randomWait > 4) {
				throw new RuntimeException("");
			}
			TimeUnit.SECONDS.sleep(randomWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + "]";
	}

	public static Order getOrder() {
		
		return new Order("CREATE");
	}

}