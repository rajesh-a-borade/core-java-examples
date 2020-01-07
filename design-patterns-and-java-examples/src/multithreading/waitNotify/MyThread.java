package multithreading.waitNotify;

public class MyThread implements Runnable {

	private String threadName;
	private int time;
	
	public MyThread(String threadName, int time) {
		this.threadName = threadName;
		this.time = time;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(this.time);
				System.out.println(this.threadName + " - " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
