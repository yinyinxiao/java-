
public class Eobject {
	public static void main(String[] args){
		System.out.println("A����֮ǰ");
		try{
			int arr[]=new int[5];
			arr[0]=3;
			arr[1]=6;
			int result=arr[0]/arr[1];
			System.out.println("������������"+result);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}catch(ArithmeticException ex){
			ex.printStackTrace();
		}finally{
			System.out.println("�����Ƿ����Ҫִ��");
		}
		System.out.println("main ��������");
	}
	
}
