package com.ssafy.algo01;

import java.util.ArrayList;
import java.util.Scanner;

public class BJO_1244 {

	public static void main(String[] args) {
		int N; //스위치 길이
		int[] sw; //스위치 배열
		int num; //학생 수
		int sx,cnt; //성별,몇번
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		sw=new int[N]; //스위치 배열 생성
		for(int i=0;i<sw.length;i++)
			sw[i]=sc.nextInt(); //스위치 저장
		num=sc.nextInt(); //학생수
		for(int n=0;n<num;n++) {
			sx=sc.nextInt(); //성별
			cnt=sc.nextInt()-1; //몇 번 인덱스
			//남자면
			if(sx==1) {
				for(int i=cnt+1;i<=sw.length;i=i+(cnt+1)) {
					if(sw[i-1]==0)
						sw[i-1]=1;
					else
						sw[i-1]=0;
				}
			//여자면
			}else {
				int m=1;
				int low=cnt-m;
				int high=cnt+m;
				//인덱스 추가할 list
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(cnt);
				while(low>=0 && high<N) {
					if(sw[low]==sw[high]) {
						arr.add(low);
						arr.add(high);
						m++;
						low=cnt-m;
						high=cnt+m;
					}else break;
				}
				
				for(int s:arr) {
					if(sw[s]==0)
						sw[s]=1;
					else
						sw[s]=0;
				}
					
			}
		}
			for(int i=1;i<=sw.length;i++) {
				System.out.printf(sw[i-1]+" ");
				if(i%20==0)
					System.out.println();
		}
	}
}
