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
  static int[] dp;
  static int helper(int n, int k) {
     if(k==1) {
      dp[k] = 1;  
      return 1;
   }
     if(dp[k]!=-1) return dp[k];
     int res = 0;
     for(int i=1;i<7;i++) {
         if(k-i>=0) res+=dp[k-i];   
     }
     dp[k] = res;
     return res;
  }
  public static void main(String[] args) {
      FastReader fs = new FastReader();
      int n = fs.nextInt();
      dp = new int[n+1];
      dp[0] = 1;
      for(int i=1;i<=n;i++) dp[i] = -1;
      int res = 0;
      for(int i=1;i<=n;i++) {
         res = helper(n,i);
         System.out.println(i+" "+res);
      }
      System.out.println(res);
   }
}
