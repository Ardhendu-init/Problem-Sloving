class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0 ){
           return 0;
        }
        
        int s2 = 0;
        for(int i : nums){
            s2+=i;
        }
        if((s2+target)<0 || (s2+target)%2 !=0 ){
            return 0;
        }
        int s1 = (target+s2)/2;
        return targetSum(s1 , nums);
    }
    
    public static int targetSum(int tar , int arr[]){
        int n = arr.length;
        int dp [][] = new int [n+1][tar+1];
        
        for(int i = 0 ; i <dp.length ; i++ ){
            for(int j = 0 ; j < dp[0].length ; j++){
                if(i ==0 && j==0){
                    dp[i][j] = 1;
                }else if(i == 0){
                    dp[i][j] =0;
                }else{
                    int val = arr[i-1];
                    if(j >= val){
                       dp[i][j] = dp[i-1][j-val]+dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                    
                }
            }
        }
        return dp[n][tar];
    }
}