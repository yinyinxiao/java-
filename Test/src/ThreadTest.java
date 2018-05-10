
public class ThreadTest {
		public static void main(String[] args){
			new ThreadT().start();
			for (int i = 0; i < 5; i++) {
				System.out.println("main线程"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}
}
 class ThreadT extends Thread{
	 public void run(){
		 for(int i=0;i<6;i++){
			 System.out.println("test正在运行"+i);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 }
		 
	 }
 }