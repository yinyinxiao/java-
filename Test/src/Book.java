class Books{
	private String title;
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	private double price;
	
	
	@Override
	public String toString(){
		return "图书名字"+this.title+",价格"+this.price;
	}
}
public class Book {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?>clsClass=Class.forName("Books");
		Books book=(Books)clsClass.newInstance();//实例化一个对象
		book.setTitle("java开发");
		book.setPrice(90);
		System.out.println(book);
	}
	
}
