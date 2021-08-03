package hwajava06_서울_13_장원경;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;


public class ProductTest2 {

	static IProductMgr manager=ProductMgrImpl.getInstance();
	
	static BufferedReader br=new BufferedReader(
			new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println("--원경 전자제품 made by 원경.");
		while(true) {
			print();
			int n;
			try {
				n = Integer.parseInt(br.readLine());
				switch (n) {
					case 0: exit(); break;
					case 1: add();  break;    
					case 2: list(); break;  
					case 3: searchbyname(); break;
					case 4: changeprice(); break;
					default: exit(); break;
				}
			} catch (Exception e) {
				System.out.println("이상한걸 눌렀어요!");
				e.printStackTrace();
			} 
		}
	}
	private static void changeprice() {
		int num=0;
		String price="";
		System.out.println("상품 번호를 입력해주세요");
		try {
			num=Integer.parseInt(br.readLine());
			System.out.println("변경할 가격을 입력해주세요.");
			price=br.readLine();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manager.modify(num, price);
		list();
	
		
	}
	//상품명으로 상품 검색
	private static void searchbyname() {
		String name="";
		System.out.println("찾으시는 상품의 이름을 입력해주세요.");
		try {
			name=br.readLine();
		} catch (IOException e) {
			System.out.println("유효한 이름이 아닙니다!");
		}
		
		for(Product p:manager.searchByName(name))
			System.out.println(p);
		
	}

	public static void add() {
		int number=0;
		String name="";
		int price=0;
		int quantity=0;
		String d_type="";
		int inch=1;
		int l=1;
		int kind=1;
		System.out.println("###################################");
		System.out.println("TV 1, Refri. 2번입니다.");
		try {
			kind=Integer.parseInt(br.readLine());
			if(kind==1) {
				System.out.println("ID를 입력하세요.");
				number=Integer.parseInt(br.readLine());
				System.out.println("제목을 입력하세요.");
				name=br.readLine();
				System.out.println("가격을 입력하세요.");
				price=Integer.parseInt(br.readLine());
				System.out.println("수량을 입력하세요.");
				quantity=Integer.parseInt(br.readLine());
				System.out.println("넓이를 입력하세요.");
				inch=Integer.parseInt(br.readLine());
				System.out.println("제품타입을 입력하세요.");
				d_type=br.readLine();
				manager.add(new TV(number, name, price, quantity, inch, d_type));
				
			}else if(kind==2) {
				System.out.println("ID를 입력하세요.");
				number=Integer.parseInt(br.readLine());
				System.out.println("제목을 입력하세요.");
				name=br.readLine();
				System.out.println("가격을 입력하세요.");
				price=Integer.parseInt(br.readLine());
				System.out.println("수량을 입력하세요.");
				quantity=Integer.parseInt(br.readLine());
				System.out.println("용량을 입력하세요.");
				l=Integer.parseInt(br.readLine());
				
				manager.add(new Refrigerator(number,name,price,quantity,l));
			}
		} catch (Exception e) {
			System.out.println("잘못된 번호를 입력하였습니다.");
		} 
		System.out.println("-------------목록----------------");
		list();
	}
	public static void list() {
		if(manager.getList().length==0) {
			System.out.println("입고된 제품이 없습니다.");
		}else {
			for (Product b: manager.getList()) {
				System.out.println(b);
			}
		}
	}
	public static  void exit() {
		System.out.println("~~~~ 원경 전자제품입니다. Good Bye~~~~. ");
		///System.out.println(new Date());
	    System.exit(0);
	}
	public static  void print() {
		System.out.println("*********************************");
		System.out.println("--안녕하세요. 원경 전자제품입니다.--");
		System.out.println("--원하는 작업을 선택하십시오.");
		System.out.println("--작업끝 0");
		System.out.println("--전자제품 추가 1");
		System.out.println("--전체 전자제품 목록 출력 2");
		System.out.println("--상품명으로 상품 검색하기 3");
		System.out.println("--상품번호와 가격을 입력 받아 상품 가격을 변경하기 4");
		System.out.println("*********************************");
	}
	
	
	
	

}