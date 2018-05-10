import java.util.ArrayList;

class TestReturn{
	private ArrayList<Integer>intArray=new ArrayList<Integer>();
	
	public TestReturn() {
		intArray.add(1);
		intArray.add(2);
		intArray.add(3);
	}
	ArrayList<Integer>getIntArray(){
		return intArray;
	}
}
public class ReturnVariable {
	public static void main(String[] args){

		TestReturn testReturn=new TestReturn();
		ArrayList<Integer>intArrayList=testReturn.getIntArray();
	System.out.println(intArrayList.size());
	
	intArrayList.add(6);
	System.out.println(intArrayList.size());
	ArrayList<Integer>intArrayList2=testReturn.getIntArray();
	System.out.println(intArrayList.size());
	}
	
}
