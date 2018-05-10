//Object中的equals比较的是两个对象的地址是否相等，如果想要比较内容，我们需要覆写，覆写equals时就要覆写hashCode(),这样才嫩保证两个对象拥有相同的hashCode
class Person{
	private String name;
	private int age;
	public Person(String nString,int age){
		this.name=nString;
		this.age=age;
	}
	
	public boolean equals(Object o){
		boolean temp=true;
		Person p1=this;
		if(o instanceof Person){
			Person p2=(Person)o;
			if(!(p1.name.equals(p2.name)&&p1.age==p2.age)){
				temp=false;
			}
		}else{
			temp=false;
		}
		return temp ;
	}
}
public class ObjectDemo {

}
