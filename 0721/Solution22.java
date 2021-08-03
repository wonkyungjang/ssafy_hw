package com.ssafy.algo;
import java.util.Scanner;

public class Solution22 {
	
	static int T;
	static int num;
	static int N,S;
	static int[][] arr;
	static int[][] strider;
	static int[] dr= {100,-1,1,0,0};
	static int[] dc= {100,0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		T=scanner.nextInt();
		
		for(int t=1;t<=T;t++) {
			num=0;
			N=scanner.nextInt(); //연못의 크기
			S=scanner.nextInt(); //소금쟁이의 수
			arr = new int[N][N];			
			strider=new int[S][3]; //소금쟁이 r c d
			for(int i=0;i<S;i++) {
				int r=scanner.nextInt(); //행
				int c=scanner.nextInt(); //열
				int d=scanner.nextInt(); //방향
				strider[i][0]=r;
				strider[i][1]=c;
				strider[i][2]=d;
				
				if(go(strider[i])==true)
					num++;
			
			}
			//출력
			System.out.println("#"+t+" "+num);	
		}
	}
	
	//n은 소금쟁이의 수
	private static boolean go(int[] sogum) {
		int count=3;
		int nr=sogum[0];
		int nc=sogum[1]; 
		int nd=sogum[2];
		
		while(count!=0)	{
			nr=nr+(dr[nd]*count); //소금쟁이가 움직인 행
			nc=nc+(dc[nd]*count); //소금쟁이가 움직인 열
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && arr[nr][nc]!=-1) {
				count--;
			}else {
				return false;
			}
		}
//	}
		arr[nr][nc]= -1;//소금쟁이가 여기서 멈춤
		return true;
	}
	


}
