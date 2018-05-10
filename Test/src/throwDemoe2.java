
public class throwDemoe2 {
	public static void main(String[] args){
		int[] arr=new int[5];
		try{
			setZero(arr,10);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("异常"+e);
		}
		System.out.println("main方法结束");
	}
	private static 
	void setZero(int[] arr,int index)throws ArrayIndexOutOfBoundsException
	{
		System.out.println("zero方法开始");
		try{
			arr[index]=0;
		}
		catch(ArrayIndexOutOfBoundsException ex){
			throw ex;
		}finally{
			System.out.println("zero方法结束");
		}
	}
}
