package sliuyin;

public class ThreadSynchonization {
	public static void main(String[] args){
		TestThread22 t=new TestThread22();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}
class TestThread22 implements Runnable{
	private int tickets=5;
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (this) {
				if(tickets<=0)
					break;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"³öÊÛÆ±"+tickets);
				tickets-=1;
			}
			
		}
	}
	
}
