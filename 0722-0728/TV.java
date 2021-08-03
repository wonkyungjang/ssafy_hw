package hwajava06_서울_13_장원경;

public class TV extends Product{
	private int inch;
	private String d_type;
	
	
	
	public TV(int number, String name, int price, int quantity, int inch, String d_type) {
		super(number, name, price, quantity);
		this.inch = inch;
		this.d_type = d_type;
	}



	@Override
	public String toString() {
		return super.toString()+" TV [인치=" + inch + ", 디스플레이타입=" + d_type + "]";
	}



	public int getInch() {
		return inch;
	}



	public void setInch(int inch) {
		this.inch = inch;
	}



	public String getD_type() {
		return d_type;
	}



	public void setD_type(String d_type) {
		this.d_type = d_type;
	}



	
}
