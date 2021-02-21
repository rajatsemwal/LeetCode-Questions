class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String str = Integer.toString(num);
            if (str.length() % 2 == 0)
                count++;
        } 
        return count;
    }    
}
