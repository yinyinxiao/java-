package sliuyin;

public class GetSetThreadNameDemo implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Thread temp=Thread.currentThread();//��ȡִ�����������߳�ʵ��
		System.out.println("ִ�����������̵߳������ǣ�"+temp.getName());
	}
	public static void main(String[] args) {
		Thread t=new Thread(new GetSetThreadNameDemo());
		t.setName("�̷߳���");
		t.start();
	}

}
