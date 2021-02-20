class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndinghere = nums[0];
        int maxSofar = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxEndinghere = Math.max(maxEndinghere + nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxEndinghere);
        }
        return maxSofar;
    }
}
