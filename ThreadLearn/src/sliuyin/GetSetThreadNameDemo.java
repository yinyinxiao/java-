package sliuyin;

public class GetSetThreadNameDemo implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Thread temp=Thread.currentThread();//获取执行这条语句的线程实例
		System.out.println("执行这条语句的线程的名字是："+temp.getName());
	}
	public static void main(String[] args) {
		Thread t=new Thread(new GetSetThreadNameDemo());
		t.setName("线程范例");
		t.start();
	}

}
