class Solution {
    public int minDeletions(String s) {
        //store the char vs freq in hashmap
        HashMap<Character, Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch , map.get(ch)+1);
            }
        }
        // ArrayList<Integer>list = new ArrayList<>(map.values());//store the values in list 
        HashSet<Integer>set = new HashSet<>();
        int count = 0;
        for (Map.Entry ele : map.entrySet()) {
            int value = (int)ele.getValue();
            if(!set.contains(value)){
                set.add(value);
            }else{
                while(value > 0 && set.contains(value)){
                    value--;
                    count++;
                }
                set.add(value);
            }
 
        }
        return count;
    }
}
