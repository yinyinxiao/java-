
public class Eobject {
	public static void main(String[] args){
		System.out.println("A计算之前");
		try{
			int arr[]=new int[5];
			arr[0]=3;
			arr[1]=6;
			int result=arr[0]/arr[1];
			System.out.println("除法计算结果："+result);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			ex.printStackTrace();
		}catch(ArithmeticException ex){
			ex.printStackTrace();
		}finally{
			System.out.println("不管是否出错都要执行");
		}
		System.out.println("main 函数结束");
	}
	
}
