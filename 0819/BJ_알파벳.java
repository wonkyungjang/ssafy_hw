import java.util.Scanner;

public class BJ_알파벳 {
   
   static int R,C;
   static char map[][];
   //상하좌우
   static int dr[]= {-1,1,0,0};
   static int dc[]= {0,0,-1,1};
  
   static String str;
   static boolean v[][];
   
   static int max=Integer.MIN_VALUE;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      R=sc.nextInt();
      C=sc.nextInt();
      map=new char[R][C];
      v=new boolean[R][C];
      for(int i=0;i<R;i++) {
         char[]c=sc.next().toCharArray();
         for(int j=0;j<C;j++) {
            map[i][j]=c[j];
         }
      }
      str=Character.toString(map[0][0]);
  
      max=Integer.MIN_VALUE;
      dfs(0,0);
      
      System.out.println(max);
   }
   private static void dfs(int r, int c) {
      
      for(int d=0;d<4;d++) {
         
         int nr=r+dr[d];
         int nc=c+dc[d];
         
         if(!check(nr,nc)) continue;
         //문자열에 map[nr][nc]가 안들어가있으면 추가 
         if(!str.contains(Character.toString(map[nr][nc]))) {
    
            str+=Character.toString(map[nr][nc]);
            dfs(nr,nc);
            
            str=str.substring(0,str.length()-1);
         }
      }
      max=Math.max(max,str.length());
    return; 
      
   }
   private static boolean check(int nr, int nc) {
      return nr>=0 && nr<R && nc>=0 && nc<C; 
   }

}