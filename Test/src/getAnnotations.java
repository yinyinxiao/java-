import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class Info{
	@Override
	@Deprecated
	@SuppressWarnings(value="this is a warning")
	public String toString(){
		return "Hellow";
	}
}
public class getAnnotations {
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException{
		Class<?> cls=Class.forName("Info");
		Method toStringMethod=cls.getMethod("toString");
		
		Annotation ans[]=toStringMethod.getAnnotations();
		for(int i=0;i<ans.length;i++){
			System.out.println(ans[i]);
		}
	}
}
