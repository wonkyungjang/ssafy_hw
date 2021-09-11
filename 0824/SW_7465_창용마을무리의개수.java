import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SW_7465_창용마을무리의개수 {

	static int T,N,M;
	static int map[][];
	static int p[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map=new int[M][2];
			p=new int[N+1];
			for(int i=0;i<M;i++) {
				int s=sc.nextInt();
				int e=sc.nextInt();
				map[i][0]=s;
				map[i][1]=e;
			}
			
			make();
			
			for(int i=0;i<M;i++) {
				int S=map[i][0];
				int E=map[i][1];
				//짱이 다르면 합치자
				int fS=find(S);
				int fE=find(E);
				if(fS!=fE) {
					p[fE]=fS;
				}
			}
			
			int cnt=0;
			for(int i=1;i<p.length;i++) {
				if(p[i]==i) cnt++;
			}
			
			System.out.println("#"+t+" "+cnt);
}
	}
	private static void make() {
		for(int i=1;i<p.length;i++) {
			p[i]=i;
		}
	}
	//짱 찾기
	private static int find(int a) {
		if(a==p[a]) return a;
		return p[a]=find(p[a]);
	}
	
	//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	
		/*private static boolean union(int a,int b) {
			int aRoot=find(a);
			int bRoot=find(b);
			//부모가 같으면
			if(aRoot==bRoot) return false; //이미 같은 집합으로 합치지 않음
			p[bRoot]=aRoot; //b의 부모는 a다 = a에 b가 흡수됨
			return true;
		}*/
	}
