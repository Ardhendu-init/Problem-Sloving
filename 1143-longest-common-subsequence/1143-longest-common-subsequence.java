class Solution {

    //Tabulation way : top-down approach
    //     public int longestCommonSubsequence(String text1, String text2) {
    //         int dp[][] = new int[text2.length()+1][text1.length()+1];

    //         for(int i = dp.length-1; i>= 0 ; i--){
    //             for(int j = dp[i].length-1 ; j>= 0 ; j--){
    //                 if(i == dp.length-1 || j==dp[i].length-1){
    //                     dp[i][j] = 0;
    //                 }else{
    //                     char c1 = text1.charAt(j);
    //                     char c2 = text2.charAt(i);
    //                     if(c1==c2){
    //                         dp[i][j] = dp[i+1][j+1]+1;
    //                     }else{
    //                         dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
    //                     }
    //                 }
    //             }
    //         }
    //         return dp[0][0];
    //     }
    //with Memoization

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <dp.length; i++) {
            for(int j =0 ;j<dp[0].length;j++){
               dp[i][j] = -1;
            }
        }
        return lcs(text1 , text2 ,text1.length(), text2.length(), dp );
    }
    public static int lcs (String s1 , String s2 , int m , int n,int dp[][] ){
        if(m ==0 || n== 0){
            return 0;
        }
        if(dp[m][n]!= -1){
            return dp[m][n];
        }
        if(s1.charAt(m-1)== s2.charAt(n-1)){
            dp[m][n] = 1+lcs(s1, s2 , m-1 , n-1, dp);
            return dp[m][n];
        }else{
            return dp[m][n] = Math.max(lcs(s1, s2 , m , n-1, dp),lcs(s1, s2 , m-1 , n, dp));
        }
    }
}
