import java.util.Date;
public class TestReflection {
	public static void main(String[] args)throws Exception{
		Date data=new Date();
		Class<?> cls=data.getClass();
		System.out.print(cls);
	}
}
