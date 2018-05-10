package sliuyin;

public class SleepInterrupt2 {
	
	public static void main(String[] args){
		Thread thread=Thread.currentThread();
		System.out.println("A:thread.isInterrupted()="+thread.isInterrupted());
		thread.interrupt();
		System.out.println("B:thread.isInterrupted()="+thread.isInterrupted());
		System.out.println("C:thread.ininterrupted()="+thread.isInterrupted());
		//已经被中断，所以为抛出异常
		try {
			Thread.sleep(20000);
			System.out.println("线程没有被中断");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("线程被中断了");
		}
		//因为上面抛出异常，处理异常中断，清楚中断
		System.out.println("D:thread.isinterrupted()="+thread.isInterrupted());
	}
}
