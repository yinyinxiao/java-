import java.util.Arrays;
import java.util.Comparator;

class BookT{
	private String titleString;
	private double price;
	
	public BookT(String titleString,double price){
		this.titleString=titleString;
		this.price=price;
	}
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString(){
		return this.titleString+":"+this.price;
	}
}
class testBook implements Comparator<BookT>{

	@Override
	public int compare(BookT o1, BookT o2) {
		// TODO Auto-generated method stub
		if (o1.getPrice()>o2.getPrice()) {
			return 1;
		}else if(o1.getPrice()<o2.getPrice()){
			return -1;
		}else {
			return 0;
		}
	}
	
}
public class CompareToTest {
	public static void main(String[] args){
	BookT[] books=new BookT[]{new BookT("ÓïÎÄ",20),new BookT("ÊýÑ§", 39),new BookT("Ó¢Óï", 56)};
	Arrays.sort(books, new testBook());
	System.out.println(Arrays.toString(books));
	System.out.println(books[0]);
	}
}
