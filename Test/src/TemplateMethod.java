abstract class Action{
	public static final int EAT=1;
	public static final int WORK=2;
	public static final int SLEEP=5;
	public static final int RUN=10;
	public abstract void eat();
	public abstract void sleep();
	public abstract void run();
	public abstract void work();
	public void command(int ch){
		switch (ch) {
		case EAT:
			this.eat();
			break;
		case WORK:
			this.work();
		case SLEEP:
			this.sleep();
		case RUN:
			this.run();
		case EAT+WORK:{
			this.eat();
			this.work();
		}
		case EAT+RUN+WORK:
		{
			this.eat();
			this.run();
			this.work();
		}
		case EAT+WORK+SLEEP+RUN:{
			this.eat();
			this.work();
			this.sleep();
			this.run();
		}
		default:
			break;
		}
	}
	
}
class Robort extends Action{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("为机器人加燃料");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("让机器人工作");
	}
	
}
class Woman extends Action{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("美女吃饭");
	}

	
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("美女睡觉");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("美女跑步");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}
	
}
public class TemplateMethod {

}
