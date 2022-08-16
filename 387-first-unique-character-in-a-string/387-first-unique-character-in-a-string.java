class Solution {
    public int firstUniqChar(String s) {
        char charArr [] = s.toCharArray();
        int arr [] = new int [26];
        
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            int val = ch-'a';
            arr[val]++;
        }
        for(int i = 0 ; i < s.length(); i++){
            if(arr[charArr[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }
}