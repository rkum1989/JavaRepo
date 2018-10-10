package com.java8.concurrency;

import java.nio.channels.IllegalSelectorException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureSimpleSnippet {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long started = System.currentTimeMillis();

		// configure CompletableFuture
		CompletableFuture<Integer> futureCount = createCompletableFuture();

		// continue to do other work
		System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

		// now its time to get the result
		try {
			int count = futureCount.get();
			System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds");

			System.out.println("Result " + count);
		} catch (InterruptedException | ExecutionException ex) {
			// Exceptions from the future should be handled here
		}

		CompletableFuture<String> data = createCompletableFuture().thenApply((Integer count) -> {
			int transformedValue = count * 10;
			return transformedValue;
		}).thenApply(transformed -> "Finally creates a string: " + transformed);

		try {
			System.out.println(data.get());
		} catch (InterruptedException | ExecutionException e) {

		}

		Executor executor = Executors.newFixedThreadPool(10);
		
		//Use runAsync() if you don't have to return any future value
		CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
			try {
				TimeUnit.SECONDS.sleep(5);
				
			}catch(InterruptedException e) {
				throw new IllegalSelectorException();
			}
		}, executor);
		
		System.out.println("running task under runAsync().........");
		System.err.println("future result........."+ future.get());
		
		
		CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() ->{		
			try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		}, executor);
		
		System.out.println("running task under supplyAsync().........");
		System.err.println("supplyAsync() result........."+ futureSupplyAsync.get());
		
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			   try {
			       TimeUnit.SECONDS.sleep(1);
			   } catch (InterruptedException e) {
			       throw new IllegalStateException(e);
			   }
			   return "Rituraj";
			}).thenApply(name -> {
				return "Hello "+ name;
			}).thenApply(greet -> {
				return greet + " welcome to Asynchronous programming........";
			});
		
		System.out.println(whatsYourNameFuture.get());
		
		CompletableFuture.supplyAsync(() -> {
			return "Chemical product ANZZZZZ";
		}).thenAccept(product -> {
			System.out.println("Got product detail from remote service " + product);
		});
		
		
		CompletableFuture.supplyAsync(() -> {
		    return "Hello thenRun()";
		}).thenRun(() -> {
		    // Computation Finished.
		});
		
		
	}

	
	private static CompletableFuture<Integer> createCompletableFuture() {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(() -> {
			try {
				// simulate long running task
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
			return 20;
		});
		return futureCount;
	}

}
