
public class throwDemo {
	public static void main(String[] args){
		try{
			throw new ArrayIndexOutOfBoundsException("�����Զ�����쳣�������½�Խ��");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
	}
}
