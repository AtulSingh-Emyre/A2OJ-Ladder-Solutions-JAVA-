import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.math.BigDecimal;
import java.util.*;
public class Solution {
   static class Algebra {
      public static int GCD(int a, int b) {
         return b==0?a:GCD(b,a%b);
      }
   }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
        int[] nextintArr(int n, FastReader fs) {
           int[] arr = new int[n];
           for(int i=0;i<n;i++) {
              arr[i] = fs.nextInt();
           }
           return arr;
        }
        String next() {
           while (st == null || !st.hasMoreElements()) {
              try {
                 st = new StringTokenizer(br.readLine());
              }
              catch (IOException e) {
                 e.printStackTrace();
              }
           }
           return st.nextToken();
        }
        int nextInt() {
           return Integer.parseInt(next());
        }
        long nextLong() {
           return Long.parseLong(next());
        }
        double nextDouble() {
           return Double.parseDouble(next());
        }
        String nextLine() {
           String str = "";
           try {
              str = br.readLine();
           }
           catch (IOException e) {
              e.printStackTrace();
           }
           return str;
        }
     }
     static void ln(String s){
        System.out.println(s);   
     }
     
     static int abs(int a,int b){
      if(b>a) return b-a;
      return a-b;
  }
  
  public static char nextChar(char curr) {
     if(curr == 'z') return 'a';
     else return (char)((int)curr+1);
  }
  
  public static int factorial(int i) {
     int res = 1;
     while(i>0) res*=i--;
     return res;
  }
  static int[][] dp;
    public static int solve(int a, int b) {
        if(a == b) return 0;
        int l = Math.max(a, b);
        int w = Math.min(a, b);
        if(dp[l][w]!=-1) return dp[l][w];
        return dp[l][w] = 1 + solve(l-w, w);
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int a = fs.nextInt();
        int b = fs.nextInt();
        int l = Math.max(a, b);
      //   int w = Math.min(a, b);
        dp = new int[l+1][l+1];
        Arrays.stream(dp).forEach(ar -> Arrays.fill(ar,-1));
        for(int i=0;i<=a;i++) for(int j=0;j<=b;j++) {
         if(dp[i][j]!=-1) continue;
         if(i==0 || j==0 || i==j) dp[i][j] = 0;
         else {
            int res = Integer.MAX_VALUE;
            for(int i1 = 1;i1<i;i1++) {
               res = Math.min(dp[i1][j]+dp[i-i1][j]+1,res);
            }
            for(int j1 = 1;j1<j;j1++){
               res = Math.min(dp[i][j1]+dp[i][j-j1]+1,res);
            }
            dp[i][j] = dp[j][i] = res;
         }
        }
      //   Arrays.stream(dp).forEach(ar -> System.out.println(Arrays.toString(ar)));

        System.out.println(dp[a][b]);
    }
}
