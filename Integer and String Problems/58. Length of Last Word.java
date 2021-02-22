class Solution {
    public int lengthOfLastWord(String s) {
        int lastwordlen = 0;
        boolean nonemptychar = true;
        
        if(s.length() == 0)
            return lastwordlen;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                lastwordlen++;
                nonemptychar = false;
            }
            else {
                if(!nonemptychar) {
                    break;
                }
            }
        }
        return lastwordlen;
    }
}
