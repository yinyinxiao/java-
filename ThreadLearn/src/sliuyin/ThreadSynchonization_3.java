package sliuyin;

public class ThreadSynchonization_3 {

}
class testThread3 implements Runnable{
	private int tickets=5;
	public void run() {
		// TODO Auto-generated method stub
		while(tickets>0){
			sale();
		}
	}
	public synchronized void sale(){
		if(tickets>0){
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