package hex.com.test07.Thread.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {

	private static class SumToN implements Callable<Integer> {

		private int n;

		public SumToN(int n) {
			this.n = n;
		}

		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += i;
			}
			return sum;
		}

	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<Integer> futureVal1 = executor.submit(new SumToN(100));
		Future<Integer> futureVal2 = executor.submit(new SumToN(1000));
		try {
			System.out.println(futureVal1.get());
			System.out.println(futureVal2.get(2000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
}