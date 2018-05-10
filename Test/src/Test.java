import java.util.EnumMap;
import java.util.Map;

enum newColor{
		RED("��ɫ",4),GREEN("��ɫ",5),BLUE("��ɫ",6);
		private String name;
		private int index;
		private newColor(String name,int index) {
			this.name=name;
			this.index=index;
		}
		public static String getName(int index){
			for(newColor c:newColor.values()){
				if(c.getIndex()==index){
					return c.name;
				}
			}
			return null;
		}
		public String getName(){
			return name;
		}
		public static void setName(int index,String name) {
			for (newColor c:newColor.values()) {
				if (c.getIndex()==index) {
					c.name=name;
					return ;
				}
			}
		}
		public int getIndex(){
			return index;
		}
		public static void setIndex(int index,String name){
			for (newColor c:newColor.values()) {
				if(c.getName()==name){
					c.index=index;
					return;
				}
			}
		}
		
}

public class Test{
	public static void main(String[] args){
		System.out.println("--------���ö���е�Ԫ��---------");
		System.out.println(newColor.RED.getIndex()+":"+newColor.RED.getName());
		newColor.setIndex(7, "��ɫ");
		System.out.println(newColor.getName(7));
	}
	
	
}
