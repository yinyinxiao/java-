import org.omg.CORBA.PUBLIC_MEMBER;
//代理设计模式，一个接口另个子类，一个子类负责真是的业务操作功能，另外一个字迹负责完成与真是业务有关的操作
abstract class Subject{//代理请求
	abstract public void request();
}
class RealSubject extends Subject{//真实角色

	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("我是红酒厂商，欢迎品尝购买");
	}
}
class ProxySubject extends Subject{//代理角色
	private RealSubject realSubject;
	@Override
	public void request() {
		// TODO Auto-generated method stub
		preRequest();
		if(realSubject==null){
			realSubject=new RealSubject();
		}
		realSubject.request();
		postRequest();
		
	}
	private void preRequest(){
		System.out.println("广告宣传，免费品尝");
	}
	private void postRequest(){
		System.out.println("付款购买");
	}
}
public class ProxyTest {
	public static void main(String[] args){
		Subject subject=new ProxySubject();
		subject.request();
	}
}
