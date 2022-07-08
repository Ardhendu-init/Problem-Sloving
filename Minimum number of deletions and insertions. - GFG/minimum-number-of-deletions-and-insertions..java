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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    int m = str1.length();
	    int n = str2.length();
	    
	    int dp[][] = new int[m + 1][n+ 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[m][n];
        int factor = (m-lcs)+(n-lcs);
        return factor;
	} 
}