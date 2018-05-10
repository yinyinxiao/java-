package sliuyin;

public class StartThreadDemo extends Thread{
	public void run(){
		for (int i = 0; i < 5; i++) {
			printMsg();
		}
	}
	public void printMsg(){
		Thread thread=Thread.currentThread();
		String nameString=thread.getName();
		System.out.println("name="+nameString);
	}
	public static void main(String[] args){
		StartThreadDemo t=new StartThreadDemo();
		t.setName("test");
		System.out.println("����start()����֮ǰ��t.isAlive()"+t.isAlive());
		t.start();
		System.out.println("����start()����֮ʱ��t.isAlive()"+t.isAlive());
		for(int i=0;i<5;i++){
			t.printMsg();
		}
		//���������̶����������false/����ʱ���true
		System.out.println("main��������ʱ��t.isalive()="+t.isAlive());
	}
}
