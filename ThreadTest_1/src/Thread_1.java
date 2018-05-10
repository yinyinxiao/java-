
class Sum{
	private int sum;
	public int getSum(){
		return sum;
	}
	public void setSum(int value){
		this.sum=sum;
	}
}
class Summation implements Runnable{
	private int upper;
	private Sum sumValue;
	public Summation(int upper,Sum sumValue){
		
	}
	public void run() {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<=upper;i++){
			sum+=i;
		sumValue.setSum(sum);
		}
	}
	
}
public class Thread_1 {
	public static void main(String[] args){
		if(args.length>0){
			if(Integer.parseInt(args[0])<0){
				System.out.println(args[0]+"must be>=0.");
			}else {
				Sum sum =new Sum();
				int upper=Integer.parseInt(args[0]);
				Thread thrd=new Thread(new Summation(upper, sum));
				thrd.start();
				try {
					thrd.join();
					System.out.println("the sum of"+upper+"is"+sum.getSum());
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		}else {
			System.err.println("usage:Summation<integer value>");
		}
	}
}
