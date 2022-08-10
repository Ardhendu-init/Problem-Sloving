class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if(m == 0 || n== 0){
            return "";
        }
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m;
        int j = n;
        String res = "";
        while (i > 0 && j > 0) {
            char c1 = str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);
            if (c1 == c2) {
                res = c2+res;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    res = c1+res;
                    i--;
                } else {
                    res = c2+res;
                    j--;
                }
            }
        }
           if( j != 0){
            String s = str2.substring(0,j);
            res = s+res;
        }
         if( i != 0){
            String s = str1.substring(0,i);
            res = s+res;
        }

        return res;
    }
}
