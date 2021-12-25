/*
Brute Approach -> Just merge the two arrays and find the median of the merged array. Below the code the is given the optimised approach.
Time Complexity - O(m + n) 
Space Complexity - O(m + n) (Extra space for creating merged array)
(m = length of nums1, n = length of nums2)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
        double ans;
        int[] nums3 = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0, k = 0;
        
        //merging both the given arrays
        while(i < nums1.length && j < nums2.length) {
            
            if(nums1[i] < nums2[j])
                nums3[k++] = nums1[i++];
            else
                nums3[k++] = nums2[j++];
        }
        
        while(i < nums1.length)
            nums3[k++] = nums1[i++];
        
        while(j < nums2.length)
            nums3[k++] =nums2[j++];
        
        //finding the median now
        
        if(nums3.length % 2 == 1)
            ans = nums3[nums3.length/2];
        else
            ans = (double)(nums3[nums3.length/2 - 1] + nums3[nums3.length/2])/2;
        
        return ans;
    }
}

/*
Optimised Approach -> Without actually merging the given arrays, try to find the indexes in both the arrays which can tell that which elements will be the extreme ones of the
left subaray and right subarray of the merged array. We need to find the largest extreme element of left subarray and smallest extreme element of right subarray
(of the assumed merged array). Once we find these elements, we can easily find the median without actually merging the given arrays. We will be using Binary search for finding
those elements. Hence, optimising the time and space complexity of brute force approach.
Time Complexity - O(log(min(m,n))) (min(m,n) because we will be iterating over the smaller array)
Space Complexity - O(1)
For better understansing, see this video - https://www.youtube.com/watch?v=jDJuW7tSxio
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) {
            
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int lo = 0, hi = nums1.length, totallen = nums1.length + nums2.length;
        
        while(lo <= hi) {
            
            int aleft = lo + (hi - lo)/2;
            int bleft = (totallen + 1)/2 - aleft;
            
            int al = (aleft == nums1.length) ? Integer.MAX_VALUE : nums1[aleft];
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : nums1[aleft - 1];
            int bl = (bleft == nums2.length) ? Integer.MAX_VALUE : nums2[bleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : nums2[bleft - 1];
            
            if(alm1 <= bl && blm1 <= al) {
                
                double ans;
                if(totallen % 2 == 0) {
                    
                    int leftmax = Math.max(alm1, blm1);
                    int rightmin = Math.min(al, bl);
                    
                    ans = (double)(leftmax + rightmin)/2;
                }
                
                else {
                    
                    ans = (double)Math.max(alm1, blm1);
                }
                
                return ans;
            }
            
            else if(alm1 > bl)
                hi = aleft - 1;
            
            else if(blm1 > al)
                lo = aleft + 1;
        }
        
        return 0;
    }
}
