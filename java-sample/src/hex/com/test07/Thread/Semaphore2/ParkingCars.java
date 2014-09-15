package hex.com.test07.Thread.Semaphore2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 本文给出的一个示例模拟30辆车去泊车,而车位有10个的场景. 
 * 当车位满时,出来一辆车,才能有一辆车进入停车.
 *
 */
public class ParkingCars {

	private static final int NUMBER_OF_CARS = 30;

	private static final int NUMBER_OF_PARKING_SLOT = 10;

	public static void main(String[] args) {

		/*
		 * 采用FIFO, 设置true
		 */
		Semaphore parkingSlot = new Semaphore(NUMBER_OF_PARKING_SLOT, true);

		ExecutorService service = Executors.newCachedThreadPool();

		for (int carNo = 1; carNo <= NUMBER_OF_CARS; carNo++) {
			service.execute(new Car(parkingSlot, carNo));
		}

		sleep(3000);

		service.shutdown();

		/*
		 * 输出还有几个可以用的资源数
		 */
		System.out.println(parkingSlot.availablePermits() + " 个停车位可以用!");
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}