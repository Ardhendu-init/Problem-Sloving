class Solution {

    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g ; j < n; j++, i++) {
                if(g == 0){
                    dp[i][j] =1;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j]=1;
                    }
                }else {
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 2+dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        int plen = dp[0][n-1];
        
        return n - plen;
    }
}
