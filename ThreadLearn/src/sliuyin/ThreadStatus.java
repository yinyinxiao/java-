package sliuyin;

import java.util.Scanner;

public class ThreadStatus implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("��������״̬");
		Scanner scanner=new Scanner(System.in);
		System.out.println("�ȴ�io,��������״̬");
		System.out.println("�������ַ�����");
		scanner.next();
		scanner.close();
		System.out.println("��������״̬�����½������״̬��Ȼ������״̬");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("�߳̽�������״̬");
	}
	public static void main(String[] args){
		Thread thread=new Thread(new ThreadStatus());
		System.out.println("���ڴ���״̬");
		thread.start();
		System.out.println("���ھ���״̬");
	}
}
