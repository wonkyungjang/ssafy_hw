package hwajava06_서울_13_장원경;

public class Refrigerator extends Product{
	private int L;

	
	

	public Refrigerator(int number, String name, int price, int quantity, int l) {
		super(number, name, price, quantity);
		L = l;
	}




	@Override
	public String toString() {
		return super.toString()+" 냉장고 [용량=" + L + "]";
	}




	public int getL() {
		return L;
	}




	public void setL(int l) {
		L = l;
	}



	
	
}
