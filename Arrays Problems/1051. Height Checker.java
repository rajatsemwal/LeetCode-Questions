class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] newheights = new int[heights.length];
            for(int i = 0; i < heights.length; i++) {
                newheights[i] = heights[i];
            }
        Arrays.sort(heights);
        for(int i = 0; i < heights.length; i++) {
            if(newheights[i] != heights[i])
                count++;
        }
        return count;
    }
}
