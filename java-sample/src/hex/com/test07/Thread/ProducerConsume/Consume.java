package hex.com.test07.Thread.ProducerConsume;
class Consume implements Runnable{
	SyncStack ss = null;
	public Consume(SyncStack ss) {
		super();
		this.ss = ss;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){//开始消费馒头
			SteamBread stb = ss.pop();
			System.out.println("消费了"+stb);
			try {
				Thread.sleep(100);//每消费一个馒头，睡觉100毫秒。即生产多个，消费一个
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}