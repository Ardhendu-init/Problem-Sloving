class Solution {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> dict = new HashMap<Character, Character>();
        dict.put(')', '(');
        dict.put('}', '{');
        dict.put(']', '[');
        
        
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(dict.containsKey(ch)){
                char topEle = st.size()==0?'#':st.pop();
                if(topEle != dict.get(ch)){
                    return false;
                }
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
