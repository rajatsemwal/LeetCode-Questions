/* The following approach uses Dynamic Programming. In this method, we create a 2D array, which stores the fact that whether the substring is palindrome or not.
Once we fill the array with suitable boolean values, we then count the number of substrings which are palindrome, and that will be our answer.
Try to follow this approach on paper first for better understanding...
Watch this YouTube video for detailed explanation - https://www.youtube.com/watch?v=XmSOWnL6T_I
*/

class Solution {
    public int countSubstrings(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
      //gap means the difference of characters between the start and end pointer.
        for(int gap = 0; gap < s.length(); ++gap) {
            
            for(int i = 0, j = gap; j < dp.length; ++i, ++j) {
                
              //this condition is for when substring contains single character
                if(gap == 0)
                    dp[i][j] = true;
                
              //this condition is for substring has only 2 characters
                else if(gap == 1) {
                    
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
              
              // and this condition is for when substring has more than 2 characters
                else {
                    
                  //to check if the string is palindromic or not, by checking if the extreme chars are same and the substring inside extreme chars is palindrome or not.
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
                        dp[i][j] = true;
                }
                
                if(dp[i][j] == true)
                    count++;
            }
        }
        
        return count;
    }
}
