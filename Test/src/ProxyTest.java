import org.omg.CORBA.PUBLIC_MEMBER;
//�������ģʽ��һ���ӿ�������࣬һ�����ฺ�����ǵ�ҵ��������ܣ�����һ���ּ��������������ҵ���йصĲ���
abstract class Subject{//��������
	abstract public void request();
}
class RealSubject extends Subject{//��ʵ��ɫ

	@Override
	public void request() {
		// TODO Auto-generated method stub
		System.out.println("���Ǻ�Ƴ��̣���ӭƷ������");
	}
}
class ProxySubject extends Subject{//�����ɫ
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
		System.out.println("������������Ʒ��");
	}
	private void postRequest(){
		System.out.println("�����");
	}
}
public class ProxyTest {
	public static void main(String[] args){
		Subject subject=new ProxySubject();
		subject.request();
	}
}
