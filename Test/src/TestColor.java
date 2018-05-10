
public class TestColor {
 public static void main(String[] args){
	 for (NewColor2 c:NewColor2.values()) {
		System.out.println(c.ordinal()+":"+c.name()+":"+c.getColor());
	}
 }
}
