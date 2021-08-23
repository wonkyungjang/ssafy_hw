import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1260_DFS와BFS {

	static int N,M,V; //V는 탐색을 시작할 번호
	static boolean[] visited;
	static int arr[][];
	static Queue<Integer> q; 
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		arr=new int[N+1][N+1];
		visited=new boolean[N+1];
		q= new LinkedList<Integer>();
		for(int i=0;i<M;i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			arr[start][end]=1;
			arr[end][start]=1;
		}
		visited[V]=true;
		dfs(V);
		System.out.println();
		for(int i=0;i<visited.length;i++)
			visited[i]=false;
		visited[V]=true;
		q.offer(V);
		bfs();

	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int p=q.poll();
			System.out.print(p+" ");
			for(int i=1;i<N+1;i++) {
				if(!visited[i] && arr[p][i]==1) {
					visited[i]=true;
					q.offer(i);
				}
			}	
		}	
	}
	
	private static void dfs(int t) {
		System.out.print(t+" ");
		for(int i=1;i<N+1;i++) {
			if(!visited[i] && arr[t][i]==1) {
				visited[i]=true;
				dfs(i);
			}
		}		
	}
}
