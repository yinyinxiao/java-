enum WeekDays{Sun,Mon,Tue,Wed,Thu,Fri,Sat};
public class Exercise {
	public static void main(String[] args){
		for(WeekDays w:WeekDays.values()){
			switch (w) {
			case Sun:
				System.out.println("Do sunday work");
				break;
			case Mon:
				System.out.println("Do Monday work");
			default:
				break;
			}
		}
	}
}
