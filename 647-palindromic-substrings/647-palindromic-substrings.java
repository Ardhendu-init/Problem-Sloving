class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n =s.length();
        boolean dp[][] = new boolean[n][n];
        for(int g = 0 ; g < n ; g++){
            for(int j = g , i = 0 ; j < n ; i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                    cnt++;
                }else if(g == 1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        cnt++;
                    }
                }else{
                    char a = s.charAt(i);
                    char b = s.charAt(j);
                    if(a==b && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}