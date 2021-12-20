package CSES.DynamicProgramming;

// import java.util.Arrays;

import CSES.FastReader;

public class EditDistance {
    static int[][] dp;
    public static int solve(int m, int n, String s, String s1) {
        if(m==0) return n;
        if(n==0) return m;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s.charAt(m-1)== s1.charAt(n-1)) {
            return dp[m][n] = solve(m-1, n-1, s, s1);
        }
        else return dp[m][n] = Math.min(Math.min(solve(m-1, n, s, s1)+1, solve(m-1, n-1, s, s1)+1),solve(m, n-1, s, s1)+1);
    }
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        String s = fs.nextLine();
        String s2 = fs.nextLine();
        int n = s.length();
        int m = s2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) for(int j=0; j<=n;j++) {
            if(i==0) dp[i][j] = j;
            else if(j==0) dp[i][j] = i;
            else if(s2.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
            else dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
        }
        // Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        // int temp = solve(m, n, s2, s);
        System.out.println(dp[m][n]);
   } 
}
