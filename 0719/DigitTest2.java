package com.ssafy.ws01.step3;

/**
 * 모래시계 모양의 숫자 출력하는 클래스
 */
public class DigitTest2 {

	public static void main(String[] args) {
		int target=2;
		int blank= 0;
		int count=0;
		boolean isincrease=true; //공백증가
		
		while(count!=17) {
		for(int i=0;i<blank;i++) {
			System.out.printf("%3s"," ");
		}
			for(int j=0;j<5-2*blank;j++) {
				System.out.printf("%3d",++count);
			}
			System.out.println();
			
			if(!isincrease)
				blank--;
			else
				blank++;
			
			if(target==blank)
				isincrease=false;

		}
		
	}
}