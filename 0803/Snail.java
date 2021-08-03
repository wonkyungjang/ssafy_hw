import java.util.Scanner;

public class Snail {

	private static int S,N;
	private static int[][] arr;
	private static int[] dr= {0,1,0,-1};
	private static int[] dc= {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		S=sc.nextInt(); //총 몇 번 반복할거야?
		for(int t=0;t<S;t++) {
		N=sc.nextInt(); //N*N배열
		arr=new int[N][N];
		int d=0; // dr,dc의 index
		int r=0;
		int c=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[r][c]=i*N+j+1;
				int nr=r+dr[d];
				int nc=c+dc[d];
				if(nr<N&&nr>=0&&nc<N&&nc>=0&&arr[nr][nc]==0) {
					r=nr;
					c=nc;
				}
				else {
					d=(d+1)%4;
					r=r+dr[d];
					c=c+dc[d];
				}
				
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		}
		
	}
	
}
