class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helperBacktrack(nums, new ArrayList<>(), ans, 0);
        
        return ans;
    }
    
    public void helperBacktrack(int[] nums, List<Integer> curr, List<List<Integer>> ans, int start) {
        
        ans.add(new ArrayList<>(curr));
        
        for(int i = start; i < nums.length; ++i) {
            
            curr.add(nums[i]);
            helperBacktrack(nums, curr, ans, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
