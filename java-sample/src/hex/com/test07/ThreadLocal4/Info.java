package hex.com.test07.ThreadLocal4;
class Info {
	private String name = "name";
	private String content = "content";
	private boolean flag = true;

	public synchronized void set(String name, String content) {
		if (!flag)// 标志位为false，不可以生产
		{
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setName(name);
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content);
		flag = false;// 修改标志位为false，表示生产者已经完成资源，消费者可以消费。
		super.notify();// 唤醒消费者进程
	}

	public synchronized void get() {
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + ":-->" + this.getContent());
		flag = true;// 修改标志位为true，表示消费者拿走资源，生产者可以生产。
		super.notify();// 唤醒生产者进程。
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}