enum NewColor3{
	ºìÉ«{
		public String getColor(){
			return "red";
		}
	};
	public abstract String getColor();
}
public class AbstractEnum {
	public static void main(String[] args){
		for(NewColor3 c:NewColor3.values()){
			System.out.println(c.name()+c.getColor());
		}
	}
}
