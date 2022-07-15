// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();
        if(n<= 1 || isPalindrome(str , 0 , n-1)==true ){
            return 0;
        }
        int dp[][] = new int [n][n];
        for(int a [] : dp){
            Arrays.fill(a , -1);
        }
        return helper(str, 0 , n-1 , dp);
        
    }
    static int helper(String s , int i , int j, int dp[][]){
        if(i >= j || isPalindrome(s , i , j)==true){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            if(isPalindrome(s, i, k)){
                int partitions = 1+helper(s, k+1, j, dp);
                ans = Math.min(ans, partitions);   
            }
        }
        return dp[i][j] = ans;
    }
    static boolean isPalindrome(String s , int i , int j){
        while(i < j ){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a == b){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}