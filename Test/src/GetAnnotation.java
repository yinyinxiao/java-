import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(value=RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	public String key();
	public String value();
}
class Info1{
	@Override
	@Deprecated
	@SuppressWarnings(value="")
	@MyAnnotation(key = "one", value = "test")
	public String toString(){
		return "hellow";
	}
}
public class GetAnnotation {
	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException{
		Class<?>clsClass=Class.forName("Info1");
		Method toStringMethod=clsClass.getMethod("toString");
		if (toStringMethod.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation myAnnotation=null;
			myAnnotation=toStringMethod.getAnnotation(MyAnnotation.class);
			String key=myAnnotation.key();
			String valueString=myAnnotation.value();
			System.out.println(key+"-->"+valueString);
		}
	}
}
