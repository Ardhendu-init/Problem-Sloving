class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //finding longest increasing subsequence or left slope of mountain
        int n = nums.length;
        int dp[] = new int [n];
        Arrays.fill(dp, 1);
        
        for(int i = 1 ; i <dp.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j]< nums[i]){
                    dp[i] = Math.max (dp[i], dp[j]+1);
                }
            }
        }
        
        //find longest decreasing subsequence or right slope of mountain
        int dp2[] = new int [nums.length];
        
        Arrays.fill(dp2, 1);
        
        for(int i = n-2 ; i>=0; i--){
            for(int j = n-1 ; j > i ; j--){
                if(nums[j]< nums[i]){
                    dp2[i] = Math.max (dp2[i], dp2[j]+1);
                }
            }
        }
        int max = 0;// max number of points should be in the array to make a mountain
        for(int i = 0 ; i < dp.length ;i++){
           if(dp[i]>= 2 && dp2[i]>=2){
               max = Math.max((dp[i]+dp2[i]), max);
           } 
        }
        
        //min removal = length of array - max no of points -1(-1 because in bitonic calculation we are taking the middle point twice)
        
        return n -(max-1);
    }
}