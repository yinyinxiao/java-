package sliuyin;

public class SleepInterrupt implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.print("��run�����С�����߳���Ϣ��10��");
			Thread.sleep(10000);
			System.out.println("��run�����У���������");
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("��run������-�ж��߳�");
			return;
		}
		System.out.println("��run�����У�����֮�����");
		System.out.println("��run������-�����˳�");
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
		System.out.println("��mian������-�ж������߳�");
		thread.interrupt();
		System.out.println("��main������-�˳�");
	}
	
}
