interface Book3{
	public String getTitle();
}
class Mathbook implements Book3{
	@Override
	public String getTitle(){
		return "数学";
	}
}
class Computer implements Book3{
	@Override
	public String getTitle(){
		return "计算机";
	}
}
class Factory{
	public static Book3 getInstance(String className){
		Book3 book3=null;
		try {
			book3=(Book3)Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book3;
	}
}
public class TestFactory01 {
	public static void main(String args[]){
		Book3 book=Factory.getInstance("Computer");
		System.out.print(book.getTitle());
	}
}
