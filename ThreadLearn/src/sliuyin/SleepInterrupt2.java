package sliuyin;

public class SleepInterrupt2 {
	
	public static void main(String[] args){
		Thread thread=Thread.currentThread();
		System.out.println("A:thread.isInterrupted()="+thread.isInterrupted());
		thread.interrupt();
		System.out.println("B:thread.isInterrupted()="+thread.isInterrupted());
		System.out.println("C:thread.ininterrupted()="+thread.isInterrupted());
		//�Ѿ����жϣ�����Ϊ�׳��쳣
		try {
			Thread.sleep(20000);
			System.out.println("�߳�û�б��ж�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�̱߳��ж���");
		}
		//��Ϊ�����׳��쳣�������쳣�жϣ�����ж�
		System.out.println("D:thread.isinterrupted()="+thread.isInterrupted());
	}
}
