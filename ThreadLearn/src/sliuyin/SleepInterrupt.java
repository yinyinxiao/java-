package sliuyin;

public class SleepInterrupt implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.print("在run方法中—这个线程休息了10秒");
			Thread.sleep(10000);
			System.out.println("在run方法中，继续运行");
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("在run方法中-中断线程");
			return;
		}
		System.out.println("在run方法中，休眠之后继续");
		System.out.println("在run方法中-正常退出");
	}
	public static void main(String[] args){
		SleepInterrupt sI=new SleepInterrupt();
		Thread thread=new Thread(sI);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("在mian方法中-中断其它线程");
		thread.interrupt();
		System.out.println("在main方法中-退出");
	}
	
}
