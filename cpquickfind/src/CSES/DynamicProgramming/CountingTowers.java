package CSES.DynamicProgramming;
// Knapsack

// import java.util.Arrays;

// import java.util.Arrays;

import CSES.FastReader;


public class CountingTowers {
    static long[][] dp;
    static int INF = (int)1e9 + 7;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = (int)1e6;
        int w = 2;
        dp = new long[n+1][w];
        for(int i=1;i<=n;i++) {
            if(i==1) dp[i][0] = dp[i][1] = 1;
            else {
                dp[i][0] = ((4*dp[i-1][0])%INF + (dp[i-1][1])%INF)%INF;
                dp[i][1] = (dp[i-1][0]%INF + (2*dp[i-1][1])%INF)%INF;
            }
        }
        int t = fs.nextInt();
        while(t-->0) {
            int val = fs.nextInt();
            long res = ((long)dp[val][0] + (long)dp[val][1])%INF; 
            System.out.println(res);
        }
        // Arrays.stream(dp).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}