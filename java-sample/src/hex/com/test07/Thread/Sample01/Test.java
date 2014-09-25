package hex.com.test07.Thread.Sample01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 一个List<String>中有10W条记录， 
 * 要把这个List的的内容拼接起来。
 * 启动5个线程同时处理，每个线程处理2w条记录。
 * 然后把5个线程处理的内容拼接起来
 * 
 */
public class Test {

	public static void main(String[] args) {
		try {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < 100; i++) {
				list.add(i + ",");
			}

			System.out.println(new Test().list2Str(list, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String list2Str(List<String> list, final int nThreads)
			throws Exception {
		if (list == null || list.isEmpty()) {
			return null;
		}

		StringBuffer ret = new StringBuffer();

		int size = list.size();
		ExecutorService executorService = Executors
				.newFixedThreadPool(nThreads);
		List<Future<String>> futures = new ArrayList<Future<String>>(nThreads);

		for (int i = 0; i < nThreads; i++) {
			final List<String> subList = list.subList(size / nThreads * i, size
					/ nThreads * (i + 1));
			Callable<String> task = new Callable<String>() {
				@Override
				public String call() throws Exception {
					StringBuffer sb = new StringBuffer();
					for (String str : subList) {
						sb.append(str);
					}
					return sb.toString();
				}
			};
			futures.add(executorService.submit(task));
		}

		for (Future<String> future : futures) {
			ret.append(future.get());
		}
		executorService.shutdown();

		return ret.toString();
	}
}