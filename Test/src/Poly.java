class Person{
	public void fun1(){
		System.out.println("func()1,我来自父类Person");
	}
	public void fun2(){
		System.out.println("func()2,我来自父类Person");
	}
}
class Student extends Person{
	public void fun1(){
		System.out.println("func()1,我来自子类Student");
	}
	public void fun3(){
		System.out.println("func()3,我来自子类Student");
	}
}
public class Poly {
	public static void main(String[] args){
		Person person=new Student();
		person.fun1();
		person.fun2();
	}
}
