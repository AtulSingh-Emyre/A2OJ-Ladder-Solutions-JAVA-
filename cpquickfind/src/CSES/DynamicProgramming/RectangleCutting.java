package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class RectangleCutting {
    static int[][] dp;
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
