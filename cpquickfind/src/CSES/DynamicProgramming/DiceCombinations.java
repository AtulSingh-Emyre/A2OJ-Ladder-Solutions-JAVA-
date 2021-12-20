package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class DiceCombinations {
    static int[][] dp;
    public static int numOfWays(int n, int curr) {
        if(n==0) return 1;
        if(curr==0 && n!=0) return 0;
        if(n<0) return 0;
        if(dp[n][curr]!=-1) return dp[n][curr];
        if(curr<=n) {
            return dp[n][curr] = numOfWays(n, curr-1);
        } else {
            return dp[n][curr] = numOfWays(n-curr,curr) + numOfWays(n,curr-1);
        }
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        dp = new int[n+1][7];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        System.out.println(numOfWays(n, 6));
    }
}
