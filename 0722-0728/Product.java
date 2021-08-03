package hwajava06_서울_13_장원경;

public class Product {
	private int number;
	private String name;
	private int price;
	private int quantity;
	
	
	public Product(int number, String name, int price, int quantity) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Product [제품번호=" + number + ", 제품이름=" + name +
				", 제품가격=" + price + ", 제품수량=" + quantity + "]";
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
