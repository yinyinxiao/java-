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
		System.out.println("调用start()方法之前，t.isAlive()"+t.isAlive());
		t.start();
		System.out.println("调用start()方法之时，t.isAlive()"+t.isAlive());
		for(int i=0;i<5;i++){
			t.printMsg();
		}
		//输出结果不固定，有事输出false/，有时输出true
		System.out.println("main方法结束时，t.isalive()="+t.isAlive());
	}
}
