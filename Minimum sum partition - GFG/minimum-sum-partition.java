// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    if(n==0){
	        return 0;
	    }
	    int sum = 0;
	    for(int i : arr){
	        sum+= i;
	        
	    }
	    int mid = sum/2;
	    int ist = 0;
	    for(int i = mid ; i>= 0 ; i--){
	        boolean ans = isSubsetSum(n , arr , i);
	        if(ans==true){
	           ist = i;
	           break;
	        }
	    }
	    int sec = sum-ist;
	   // System.out.println("lets find"+find);
	    return Math.abs(ist-sec);
	}
	
	static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][] = new boolean [N+1][sum+1];
        for(int i = 0 ; i <= N ; i++){
            for(int j = 0 ; j <=sum ; j++){
                if(i==0 && j ==0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j ==0){
                    dp[i][j] = true;
                    
                }else {
                    if(dp[i-1][j]==true){
                        dp[i][j]=true;
                    }else{
                        int val = arr[i-1];
                        if(j >= val){
                            if(dp[i-1][j-val]==true ){
                                dp[i][j]= true;
                            }
                        }
                    }
                }
            }
            
        }
        return dp[N][sum];
    }
}
