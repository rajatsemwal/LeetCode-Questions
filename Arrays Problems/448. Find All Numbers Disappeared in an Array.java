class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> missnum = new ArrayList<Integer>();
        HashSet<Integer> numbers = new HashSet<>();
        
        for(int i: nums)
            numbers.add(i);
        
        for(int i = 1; i <= nums.length; i++) {
            
            if(!numbers.contains(i))
                missnum.add(i);
        }
        
        return missnum;
    }
}
