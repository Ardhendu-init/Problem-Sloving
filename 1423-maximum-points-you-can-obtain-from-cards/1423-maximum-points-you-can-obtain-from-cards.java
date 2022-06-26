class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int msas = 0;//minimum subarray Sum
        int ts =0;//total sum
        int cs =0; //current sum
        int n = cardPoints.length;
        for(int i = 0 ; i < n ; i++){
            ts+=cardPoints[i];
            cs+=cardPoints[i];
            if(i < n-k){//if window size is less than the n-k
                msas+=cardPoints[i];
            }else{
                cs-= cardPoints[i-(n-k)];
                msas = Math.min(msas, cs);
            }
        }
        return ts- msas;
        
    }
}