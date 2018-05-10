
public class Test2 {
	public static void main(String[] args){
		String str1=new String("java");
		String  str2=new String("java" +
				"");
		String str3=new String("math");
		String str4=str3;
		if(str1==str2){
			System.out.println("str1==str2");
		}else{
			System.out.println("str1!=str2");
		}
		if (str1.equals(str2)) {
			System.out.println("EQUALS:str2==str1");
		}else{
			System.out.println("EQUALS:str2!=str1");
		}
		
		if(str1==str3){
			System.out.println("str1==str3");
		}else{
			System.out.println("str1!=str3");
		}
		if(str4==str3){
			System.out.println("str4==str3");
		}else{
			System.out.println("str4!=str3");
		}
		if (str4.equals(str3)) {
			System.out.println("EQUALS:str4==str3");
		}else{
			System.out.println("EQUALS:str4!=str3");
		}
		}
}
