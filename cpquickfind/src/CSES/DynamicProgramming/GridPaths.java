package CSES.DynamicProgramming;

import java.util.Arrays;

import CSES.FastReader;

public class GridPaths {
// static boolean[][] visited;
static int[][] dp;
static int INF = (int)1e9 + 7;
static int[][] dirs = {{0,1},{1,0}}; 
public static int solve(int r, int c, char[][] g, int n) {
    if(r == n-1 && c == n-1) return 1;
    if(g[r][c] == '*') return 0;
    if(dp[r][c]!=-1) return dp[r][c];
    int res = 0;
    for(int[] dir: dirs) {
        int rr = dir[0] + r;
        int cc = dir[1] + c;
        if(rr>=n || cc>=n) continue;
        res+=solve(rr,cc,g,n);
        res = res%INF;
    }
    return dp[r][c] = res%INF;

}
 public static void main(String[] args) {
    FastReader fs = new FastReader();
    int n = fs.nextInt();
    char[][] g = new char[n][n];
    for(int r = 0;r<n;r++) {
        String s = fs.nextLine();
        g[r] = s.toCharArray();
    }    
    // visited = new boolean[n][n];
    dp = new int[n][n];
    Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
    System.out.println(g[n-1][n-1] == '*'?0:solve(0, 0, g, n));

 }   
}

