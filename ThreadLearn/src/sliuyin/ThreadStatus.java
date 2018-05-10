package sliuyin;

import java.util.Scanner;

public class ThreadStatus implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("处于运行状态");
		Scanner scanner=new Scanner(System.in);
		System.out.println("等待io,处于阻塞状态");
		System.out.println("请输入字符串：");
		scanner.next();
		scanner.close();
		System.out.println("结束阻塞状态，重新进入就绪状态，然后运行状态");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("线程进入死亡状态");
	}
	public static void main(String[] args){
		Thread thread=new Thread(new ThreadStatus());
		System.out.println("处于创建状态");
		thread.start();
		System.out.println("处于就绪状态");
	}
}
