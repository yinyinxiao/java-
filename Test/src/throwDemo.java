
public class throwDemo {
	public static void main(String[] args){
		try{
			throw new ArrayIndexOutOfBoundsException("我是自定义的异常，数组月结越界");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
	}
}
