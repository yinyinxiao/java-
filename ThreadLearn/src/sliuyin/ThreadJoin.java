package sliuyin;

public class ThreadJoin {
	public static void main(String[] args){
		ThreadTest t=new ThreadTest();
		Thread pp=new Thread(t);
		pp.start();
		int i=0;
		for(int x=0;x<5;x++){
			if(i==3){
				try {
					pp.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("mainthread:"+i);
			i+=1;
		}
	}
}
class ThreadTest implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		int i=0;
		for (int x=0;x<5;x++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			i+=1;
		}
	}
	
}