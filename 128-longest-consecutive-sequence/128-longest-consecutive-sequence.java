class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean>map = new HashMap<>();
        for(int i : nums){
            map.put(i , true);
        }
        
        for(int i : nums){
            if(map.containsKey(i-1)){
                map.put(i , false);
            }
        }
        
        int lcs_len = 0;
        
        for(int i : nums){
            if(map.get(i)==true){
                int len = 1;
                int val = i;
                while(map.containsKey(val+len)){
                    len++;
                }
                // System.out.println(val +" "+ len);
                lcs_len=Math.max(len, lcs_len);
            }
        }
        return lcs_len;
    }
}