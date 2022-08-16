class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0){
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int f = map.get(ch);
                map.put(ch , f+1);
            }else{
                map.put(ch , 1);
            }
        }
        int res = -1;
          for(int i = 0 ; i < s.length();i++){
            char ch = s.charAt(i);
            if(map.get(ch)==1){
                res = i;
                break;
            }
        }
        return res;
        
    }
}