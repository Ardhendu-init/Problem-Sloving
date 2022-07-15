// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        String res = "";
        int n = S.length();
        boolean dp[][] = new boolean[n][n];
        for (int g = 0; g < n; g++) {
            for (int j = g, i = 0; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                    String temp = S.substring(i, j+1);
                    if (temp.length() > res.length()) {
                        res = temp;
                    }
                } else if (g == 1) {
                    if (S.charAt(i) == S.charAt(j)) {
                        dp[i][j] = true;
                        String temp = S.substring(i, j+1);
                        if (temp.length() > res.length()) {
                            res = temp;
                        }
                    }
                } else {
                    char a = S.charAt(i);
                    char b = S.charAt(j);
                    if (a == b && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        String temp = S.substring(i, j+1);
                        if (temp.length() > res.length()) {
                            res = temp;
                        }
                    }
                }
            }
        }
        return res;
    }
}