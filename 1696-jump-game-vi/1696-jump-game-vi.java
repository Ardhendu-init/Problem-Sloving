class Solution {

    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>(); // for storing indices
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            //checking if the value lies between the range of last k values, if not "bye-bye"
            if (list.getFirst() < i - k) list.removeFirst();
            // setting nums[i] equal to curr. value and curr. max value
            nums[i] += nums[list.getFirst()];
            //if index not between last k values, remove it.
            while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) list.removeLast();
            list.addLast(i);
        }
        return nums[nums.length - 1];
    }
}
//      public int maxResult(int[] nums, int k) {
//         int dp[] = new int [nums.length];
//          dp[nums.length-1] = nums[nums.length-1];
//          for(int i = nums.length-2 ; i>=0 ; i--){
//              int max = Integer.MIN_VALUE;  
//              for(int j = 1 ; j <= k && j+i<nums.length ;j++){
//                  max = Math.max(max, nums[i]+dp[i+j]);
//              }
//              dp[i] = max;
             
//          }
//          return dp[0];
//     }
// }
// https://leetcode.com/problems/jump-game-vi/discuss/2257293/JAVA-or-RECURSIVE-or-MEMOIZED-or-TABULATED-or-OPTIMIZED-or-DP-or