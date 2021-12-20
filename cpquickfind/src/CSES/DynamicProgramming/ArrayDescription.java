package CSES.DynamicProgramming;
// Knapsack

// import java.util.Arrays;

import CSES.FastReader;

public class ArrayDescription {
    static int[][] dp;
    static int INF = (int)1e9 + 7;
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] arr = fs.nextintArr(n, fs);
        dp = new int[m+1][n];
        int[][] dirs = {{-1,-1},{0,-1},{1,-1}};
        int total = 0;
        // run column wise and solve the problem
        for(int c=0;c<n;c++) {
            for(int r = 1;r<=m;r++) {
                if(arr[c] != 0) {
                    if(arr[c] == r && c == 0) dp[r][c] = 1;
                    else if(arr[c] == r && c!=0) {
                        for(int[] dir: dirs) {
                            int cc = c + dir[1];
                            int rr = r + dir[0];
                            if(cc<0 || cc>= n) continue;
                            if(rr<1 || rr>m ) continue;
                            dp[r][c]+=dp[rr][cc];
                        }
                    }
                    else dp[r][c] = 0;
                    dp[r][c]%=INF;
                } else {
                    if(c == 0) dp[r][c] = 1;
                    else{
                        for(int[] dir: dirs) {
                            int cc = c + dir[1];
                            int rr = r + dir[0];
                            if(cc<0 || cc>= n) continue;
                            if(rr<1 || rr>m ) continue;
                            dp[r][c]+=dp[rr][cc];
                        }
                    }
                    dp[r][c]%=INF;
                }
                if(c==n-1) {
                    total+=dp[r][c];
                }
            }
        }
        // Arrays.stream(dp).forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println(total);

    }
}