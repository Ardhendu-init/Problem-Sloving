class Solution {
    public int minScoreTriangulation(int[] values) {
        int N = values.length;
        int dp [][] = new int [N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                dp[i][j]= -1;
            }
        }
       return helper(values , 1 , N-1, dp);
    }
    static int helper(int arr[], int i , int j , int dp [][] ){
        if(i >= j ){
            return 0;
        }
        
        if(dp[i][j] != -1 ){
            return dp[i][j];
        }
         int min = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1 ; k++){
            int temp = helper(arr , i , k, dp)+helper(arr , k+1 , j, dp)+ (arr[i-1]*arr[k]*arr[j]);
            min = Math.min(min , temp);
        }
        return dp[i][j]=min;
    }
}