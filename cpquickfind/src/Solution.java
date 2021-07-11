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
  static double sum=0;
  static void sol(double c,double m,double p,double v,double cum,double length) {
	  if(c<0.000001)c=0;
      if(m<0.000001)m=0;
	  sum+= (p*cum*(length+1));
	 if(c>=v) {
		 if(m>0) {
			 sol(c-v,m+(v/2),p+(v/2),v,cum*c,length+1);
		 }
		 else {
			 sol(c-v,m,p+v,v,cum*c,length+1);
		 }
	 }
	 else if(c>0 && c<=v) {
		 if(m>0) {
			 sol(0,m+c/2,p+c/2,v,cum*c,length+1);
		 }
		 else {
			 sol(0,m,p+c,v,cum*c,length+1);
		 }
	 }
	 if(m>=v) {
		 if(c>0) {
			 sol(c+v/2,m-v,p+v/2,v,cum*m,length+1);
		 }
		 else {
			 sol(c,m-v,p+v,v,cum*m,length+1);
		 }
	 }
	 else if(m>0 && m<=v) {
		 if(c>0) {
			 sol(c+m/2,0,p+m/2,v,cum*m,length+1);
		 }
		 else {
			 sol(c,0,p+m,v,cum*m,length+1);
		 }
	 }
  }

  static int INF = (int)1e9+7;
  
  public static void main(String[] args) {
   FastReader fs = new FastReader();
   int tot = 0;
   int n = fs.nextInt();
   for (int i = 0; i < n; i++) {
      tot+=fs.nextInt();
   }
   if(tot%n==0) System.out.println(n);
   else System.out.println(n-1);
  }
}
