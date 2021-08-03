package hwajava06_서울_13_장원경;

import java.util.ArrayList;
import java.util.Arrays;


public class ProductMgrImpl implements IProductMgr{
	//리스트로 가져옴
	private ArrayList<Product> products=new ArrayList<>();
	//tv,냉장고 받아오기
	private static IProductMgr prdmgr=new ProductMgrImpl();
	
	public static IProductMgr getInstance() {
		
		return prdmgr;
	}
	
	
	public int size() {
		return products.size();
	}
	
	

	//product 추가하기
	@Override
	public void add(Product p) {
		if(p!=null) {
			if(searchByNum(p.getNumber())==null) { //저장된 isbn이 없음!
				products.add(p);
			}
		}

	}
	//상품정보 전체검색
	@Override
	public Product[] getList() {
	
		return products.toArray(new Product[size()]);//리스트를 배열로 바꿔줌
	}
	
	//상품 번호로 상품을 검색하는 기능
	@Override
	public Product searchByNum(int number) {
		for (Product p : getList()) {
			if(number==p.getNumber()) {
				return p;
			}
			}
		
		return null;
	}
	
	//상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	@Override
	public Product[] searchByName(String name) {
		ArrayList<Product> tproducts=new ArrayList<>();
		for(Product p : getList()) {
			if(p.getName().contains(name)) {
				tproducts.add(p);
			}
		}
		return tproducts.toArray(new Product[tproducts.size()]);
	}
	
	//TV 정보만 검색
	@Override
	public TV[] getTV() { //tv들만 담을 리스트
		ArrayList<TV> tvs=new ArrayList<>();
		for(Product p: getList()) {
			if(p instanceof TV) {
				tvs.add((TV)p);
			}
		}
		return (TV[]) tvs.toArray(new TV[tvs.size()]);
	}
	
	//냉장고 정보만 검색
	@Override
	public Refrigerator[] getRefri() {
		ArrayList<Refrigerator> refris=new ArrayList<>();
		for(Product p: getList()) {
			if(p instanceof Refrigerator) {
				refris.add((Refrigerator)p);
			}
		}
		return (Refrigerator[]) refris.toArray(new Refrigerator[refris.size()]);
	}
	
	
	//상품 번호로 상품을 삭제하는 기능
	@Override
	public void remove (int number) {
		for(Product p:getList()) {
			if(p.getNumber()==number) {
				products.remove(p);
			}
		}
	}
	
	//전체 재고 상품 금액을 구하는 기능
	@Override
	public int totalPrice() {
		int total=0;
		for(Product p:getList()) {
			total+=p.getPrice();
		}
		return total;
	}
	
	//400L 이상의 Refrigerator 검색
	@Override
	public Refrigerator[] searchOverCapacity() {
		ArrayList<Refrigerator> ref = new ArrayList<>();
		for(Refrigerator p:getRefri()) {
			if(p.getL()>400) {
				ref.add((Refrigerator)p);
			}
		}
		//new Product가 맞나..Refrigerator아니고..
		return (Refrigerator[]) ref.toArray(new Refrigerator[ref.size()]);
	}
	
	//50inch 이상의 TV검색
	@Override
	public TV[] searchOverWidth() {
		ArrayList<TV> tv = new ArrayList<>();
		for(TV p:getTV()) {
			if(p.getInch()>50) {
				tv.add((TV)p);
			}
		}
		return (TV[]) tv.toArray(new TV[tv.size()]);
	}
	
	//상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	
	@Override
	public void modify(int isbn, String price) {
		searchByNum(isbn).setPrice(Integer.parseInt(price));
		
	}




	
	
}
