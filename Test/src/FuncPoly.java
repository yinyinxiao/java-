class Animal{
	public void move(){
		System.out.println("�����ƶ�");
	}
}
class Fish extends Animal{
	public void move(){
		System.out.println("����ζ�");
	}
	 void run(){
		System.out.print("run");
	}
}
class Bird extends Animal{
	public void move(){
		System.out.println("����ƶ�");
	}
}
class Hourse extends Animal{
	public void move(){
		System.out.println("����ƶ�");
	}
}
public class FuncPoly {
	public static void main(String[] args){
		Animal a;
		Fish fish=new Fish();
		a=fish;
	}
}
