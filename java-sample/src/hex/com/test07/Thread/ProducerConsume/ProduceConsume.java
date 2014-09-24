package hex.com.test07.Thread.ProducerConsume;
public class ProduceConsume {

	public static void main(String[] args) throws InterruptedException {
		SyncStack ss = new SyncStack();//建造一个装馒头的框
		Producer p = new Producer(ss);//新建一个生产者，使之持有框
		Consume c = new Consume(ss);//新建一个消费者，使之持有同一个框
		Thread tp = new Thread(p);//新建一个生产者线程
		Thread tc = new Thread(c);//新建一个消费者线程
		tp.start();//启动生产者线程
		tc.start();//启动消费者线程
	}

}