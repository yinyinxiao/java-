import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Scanner;


@Retention(value=RetentionPolicy.RUNTIME)
@interface LoginInfo{
	public String name();
	public String passward();
}

class TestLogin{
	private String nameString;
	private String password;
	
	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@LoginInfo(name="liuyin",passward="123")
	public boolean login(String name,String password){
		if (this.nameString.equals(name)&&this.password.equals(password)) {
			return true;
		}else
			return false;
	}
	
}
public class LoginAnnotation {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, NoSuchMethodException{
		String nameString;
		String pwdString;
		TestLogin testLogin=new TestLogin();
		
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("input your name:");
		nameString=scanner.next();
		testLogin.setNameString(nameString);
		System.out.println("input your password:");
		pwdString=scanner.next();
		testLogin.setPassword(pwdString);
		
		Class<?>cls=Class.forName("TestLogin");
		Method stringMethod=cls.getMethod("login");
		if (stringMethod.isAnnotationPresent(LoginInfo.class)){
			LoginInfo myInfo=null;
			myInfo=stringMethod.getAnnotation(LoginInfo.class);
			boolean b=testLogin.login(myInfo.name(),myInfo.passward());
			if (b) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}

		
	}
}
