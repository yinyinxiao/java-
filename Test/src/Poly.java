class Person{
	public void fun1(){
		System.out.println("func()1,�����Ը���Person");
	}
	public void fun2(){
		System.out.println("func()2,�����Ը���Person");
	}
}
class Student extends Person{
	public void fun1(){
		System.out.println("func()1,����������Student");
	}
	public void fun3(){
		System.out.println("func()3,����������Student");
	}
}
public class Poly {
	public static void main(String[] args){
		Person person=new Student();
		person.fun1();
		person.fun2();
	}
}
