//Object�е�equals�Ƚϵ�����������ĵ�ַ�Ƿ���ȣ������Ҫ�Ƚ����ݣ�������Ҫ��д����дequalsʱ��Ҫ��дhashCode(),�������۱�֤��������ӵ����ͬ��hashCode
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
