package sliuyin;
class TestThread implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <5; i++) {
			System.out.println("testThread");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
}
public class RunnableThread {
	public static void main(String[] args){
		TestThread t1=new TestThread();
		new Thread(t1).start()
		;
		for (int i = 0; i < 5; i++) {
			System.out.println("mainthread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}
}
