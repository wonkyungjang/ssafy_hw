package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요. ");
		System.out.println("1. 5 판 3 승");
		System.out.println("2. 3 판 2 승");
		System.out.println("3. 1 판 1 승");
		System.out.println("번호를 입력하세요.");
		int i=1;//게임횟수
		int num1=scanner.nextInt();//메뉴고르기
		int num2 =0; //사용자
		int num3 =0; //컴퓨터
		int total=0; //총게임수
		int win=0;
		int u_win=0; //user가 이긴 횟수
		int c_win=0; //컴퓨터가 이긴 횟수
		
		if(num1==1) {
			total=5;
			win=3;
		}else if(num1==2) {
			total=3;
			win=2;
		}else {
			total=1;
			win=1;
		}
			while(i<=total) {
			System.out.print("가위바위보 중 하나 입력:");
			num2=scanner.nextInt();
			num3=(int)(Math.random()*3)+1;
			
			if(num2==1) {
				if(num3==1) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("비겼습니다!!");
				}else if(num3==2) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("졌습니다!!");
					c_win++;
				}else {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("이겼습니다!!");
					u_win++;
				}			
			
			}else if(num2==2) {
				if(num3==1) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("이겼습니다!!");
					u_win++;
				}else if(num3==2) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("비겼습니다!!");
				}else {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("졌습니다!!");
					c_win++;
				}
				
			}else {
				if(num3==1) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("졌습니다!!");
					c_win++;
				}else if(num3==2) {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("이겼습니다!!");
					u_win++;
				}else {
					System.out.printf("컴퓨터 : %d \n",num3);
					System.out.println("비겼습니다!!");
				}
			}
			
			if((c_win==win)||(u_win==win)) {
				break;
			}
			 i++;
			}
			
			if(c_win>u_win)
				System.out.println("### 컴퓨터 승!!!");
			else if(c_win<u_win){
				System.out.println("### 사용자 승!!!");
			}else {
				System.out.println("### 비겼습니다!!");
			}
			
		}

	}


