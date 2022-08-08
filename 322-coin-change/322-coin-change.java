class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp [] = new int [amount + 1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0]=0;
        
        for(int coin : coins ){
            for(int i = coin ; i <= amount ; i++){
                int f = dp[i-coin];
                if(f !=Integer.MAX_VALUE ){
                    dp[i] = Math.min((f+1),dp[i]); 
                }
               
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}