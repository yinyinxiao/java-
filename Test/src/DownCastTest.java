class A{
	public void print(){
		System.out.println("A");
	}
}
class B extends A{
	public void print(){
		System.out.println("B EXTENS A");
	}
	public void getB(){
		System.out.println("bÀ©³äµÄ·½·¨");
	}
}
public class DownCastTest {
	public static void main(String[] args){
		 A a=new B();
		 a.print();
		 B b=(B)a;
		 b.getB();
	}
}
