abstract class Person1{
	String name;
	int age;
	String occupation;
	public abstract String talk();
}
class Student1 extends Person1{

	public Student1(String name,int age,String occupation){
		this.name=name;
		this.age=age;
		this.occupation=occupation;
	}
	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return "学生:"+this.age;
	}
	
}
class work extends Person1{

	public work(String name,int age,String occupation){
		this.name=name;
		this.age=age;
		this.occupation=occupation;
	}
	@Override
	public String talk() {
		// TODO Auto-generated method stub
		return "工人:"+this.age+this.occupation;
	}
	
}
public class AbstractClassDemo {
	public static void main(String[] args){
		Student1 student=new Student1("liuyin", 22, "学生");
		work w=new work("zhang", 330, "dsjf");
		System.out.print(student.talk());
		
	}
}
