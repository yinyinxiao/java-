class Animal{
	public void move(){
		System.out.println("动物移动");
	}
}
class Fish extends Animal{
	public void move(){
		System.out.println("鱼儿游动");
	}
	 void run(){
		System.out.print("run");
	}
}
class Bird extends Animal{
	public void move(){
		System.out.println("鸟儿移动");
	}
}
class Hourse extends Animal{
	public void move(){
		System.out.println("马儿移动");
	}
}
public class FuncPoly {
	public static void main(String[] args){
		Animal a;
		Fish fish=new Fish();
		a=fish;
	}
}
