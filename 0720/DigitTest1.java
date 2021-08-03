package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		int save=0;
		int arr_cnt[]=new int[10];
		int arr[]=new int[100] ;
		System.out.println("정수를 입력하세요. 0이 되면 입력이 종료됩니다.");
		Scanner scanner= new Scanner(System.in);
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=scanner.nextInt();
			if(arr[i]==0) {
				save=i;
				break;
			}
		}
		
		for (int j = 0; j < save; j++) { 
			arr_cnt[arr[j]/10]++;
		}
		
		
		for(int k=0;k<arr_cnt.length;k++) {
			if(arr_cnt[k]!=0) {
				System.out.printf("%d : %d개",k,arr_cnt[k]);
				System.out.println();
			}
		}
	}

}
