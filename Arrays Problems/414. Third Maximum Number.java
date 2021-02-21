class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length-1];
        if(j < 2)
            return nums[j];
        else
            return nums[j-2];
    }
}
