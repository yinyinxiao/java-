
public class Proxy {
	public static void main(String[] args){
		Name name=new Name("liu");
		Name name2=new Name("liu");
		Name name3=name2;
		if(name==name3){
			System.out.println("name==name3");
		}else{
			System.out.println("name!=name3");
		}
		if (name.equals(name2)) {
			System.out.println("EQUALS:==");
		}else{
			System.out.println("EQUALS:!=");
		}
	}
}
class Name{
	String name;
	public Name(String n) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
}