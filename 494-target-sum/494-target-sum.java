class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length ==0){
            return 0;
        }
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if((sum+target)<0 || (sum+target)%2 !=0 ){
            return 0;
        }
        int s1 = (target+sum)/2;
        int ans = subsetSum(nums , s1);
        return ans;
    }
    
    public int subsetSum(int nums[] , int tar){
        int dp [][] = new int [nums.length+1][tar+1];
        
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                }else if(i ==0){
                    dp[i][j] = 0;
                }else{
                    int val = nums[i-1];
                    if(j>= val){
                        dp[i][j] = dp[i-1][j-val]+dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[nums.length][tar];
    }
}