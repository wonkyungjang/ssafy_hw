package hwajava06_서울_13_장원경;

public interface IProductMgr {
	/*int MAX_SIZE=100;
	int size=0;
	Product[] products=new Product[MAX_SIZE];
	*/
	//앞에 뭐가 숨겨져있다했지..? public abstract
	void add(Product p);
	Product[] getList();
	Product searchByNum(int number);
	Product[] searchByName(String name);
	TV[] getTV();
	Refrigerator[] getRefri();
	//400L 이상의 Refrigerator 검색
	Refrigerator[] searchOverCapacity();
	//50inch 이상의 TV검색
	TV[] searchOverWidth();
	//상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	void modify(int isbn, String price);
	void remove (int number);
	int totalPrice();
	
	
	
}
