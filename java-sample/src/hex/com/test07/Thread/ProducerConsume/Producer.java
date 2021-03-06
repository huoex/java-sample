package hex.com.test07.Thread.ProducerConsume;
class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack ss){
		this.ss = ss;
	}
	@Override
	public void run() {
		// 开始生产馒头
		for(int i=0;i<20;i++){
			SteamBread stb = new SteamBread(i);
			ss.push(stb);
			System.out.println("生产了"+stb);
			try {
				Thread.sleep(10);//每生产一个馒头，睡觉10毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}