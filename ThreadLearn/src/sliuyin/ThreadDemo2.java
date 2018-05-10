package sliuyin;

import java.security.PrivateKey;
import java.text.Normalizer.Form;

public class ThreadDemo2 {
	public static void main(String[] args){
		Thread2 t3=new Thread2();
		t3.start();
	}
}
class Thread2 extends Thread{
	private int tickets=5;
	public void run(){
		while (tickets>0){
			System.out.println(Thread.currentThread().getName()+"³öÊÛÆ±"+tickets);
			tickets-=1;
		}
		
	}
}