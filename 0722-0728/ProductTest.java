package hwajava06_서울_13_장원경;


public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl pmg=new ProductMgrImpl();
		
		System.out.println("**********************상품 저장**********************");
		pmg.add(new TV(1346,"samsung tv",12500000,1,55,"display"));
		pmg.add(new TV(2676,"LG tv",4000000,2,50,"rectangle"));
		pmg.add(new TV(8632,"Sky tv",26500000,1,20,"trangle"));
		pmg.add(new Refrigerator(1043,"LG refri",150000,1,500));
		pmg.add(new Refrigerator(7488,"Samsung refri",132000,1,32));
		pmg.add(new Refrigerator(6632,"GX refri",280000,1,48));
		System.out.println();
		
		System.out.println("**********************상품 전체 목록**********************");
		for (Product p : pmg.getList()) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("**********************상품번호로 검색:2676**********************");
			System.out.println(pmg.searchByNum(2676));
		System.out.println();	
		
		System.out.println("**********************상품명으로 검색:LG**********************");
			System.out.println(pmg.searchByName("LG"));
		System.out.println();
		
		System.out.println("**********************TV 목록**********************");
		for (Product TV : pmg.getTV()) {
			System.out.println(TV);
		}
		System.out.println();
		
		System.out.println("**********************냉장고 목록**********************");
		for (Product RE : pmg.getRefri()) {
			System.out.println(RE);
		}
		System.out.println();
		
		System.out.println("**********************상품 삭제 :7488**********************");
		pmg.remove(7488);
		for (Product p : pmg.getList()) {
			System.out.println(p);
		}
		
		System.out.println();
		System.out.println("상품 가격 총합 : "+pmg.totalPrice());
		
		System.out.println("*****************400L 이상의 Refrigerator 검색******************");

		for(Refrigerator ref : pmg.searchOverCapacity()) {
			System.out.println(ref);
		}
		
		System.out.println("*****************50인치 이상의 TV 검색******************");

		for(TV tvs : pmg.searchOverWidth()) {
			System.out.println(tvs);
		}
		System.out.println();
		System.out.println("************상품번호:1346, 가격 1000원으로 변동******************");

		pmg.modify(1346, "1000");
		for (Product p : pmg.getList()) {
			System.out.println(p);
		}
		System.out.println();
		
		
	}
}

