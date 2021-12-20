package CSES.Strings;

import java.util.Arrays;

public class suffixarr {
    public static void main(String[] args) {
        String S = "abaab";
        S+="$";
        char[] s = S.toCharArray();
        int n = 5;
        int[] cnt = new int[256];
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[s[i]]++;
        }
        for(int i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1];
        for(int i=1;i<n;i++) {
            p[--cnt[s[i]]] = i;
        }
        int classes = 0;
        c[p[0]] = 0;
        for(int i=1;i<n;i++) {
            if(s[p[i]] == s[p[i-1]]) c[p[i]] = classes;
            else c[p[i]] = ++classes;
        }
        // now for other iterations
        // suppose we have the value for k-1th iteration, we need to find the kth iteration.
        // use radix sort
        for(int k = 0; (1<<k) < n; k++) {
            int[] pn = new int[n];
            int[] cn = new int[n];
            for(int i=0;i<n;i++) {
                pn[i] = p[i] - (1<<k);
                if(pn[i]<0) pn[i]+=n;
            }
            cnt = new int[classes+1];
            for(int i=0;i<n;i++) cnt[c[pn[i]]]++;
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i-1];
            }
            for (int i = 0; i < cn.length; i++) {
                p[--cnt[c[pn[i]]]] = i;
            }
            cn[p[0]] = 0;
            classes = 1;
            for (int i = 1; i < cn.length; i++) {
                int curr1 = p[i];
                int curr2 = p[(i + (1<<k))%n];
                int prev1 = p[i-1];
                int prev2 = p[(i + (1<<k))%n];
                if(curr1 == prev1 && curr2 == prev2) {
                    cn[p[i]] = classes - 1;
                } else {
                    classes++;
                    cn[p[i]] = classes -1;
                }
            }
            c = cn;
            System.out.println(S);
            System.out.println(Arrays.toString(p));
            System.out.println(Arrays.toString(c));
        }
    }
}
