/*The intuition behind the solution is that whenever you encounter an island or 1, increase the perimter, because at that time, we are checking only for that
single island's perimeter. After that, check whether the current island has any neighbouring island before it or not(in previous row and column). If there exists
any neighbour, decreement the perimeter ny 2 sides, because, whenever we will merge 2 squares, we will lose 2 sides.*/


class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                
                if(grid[i][j] == 1) {
                    
                    islands += 4;
                    
                    if(i > 0 && grid[i-1][j] == 1)
                        islands -= 2;
                    if(j > 0 && grid[i][j-1] == 1)
                        islands -= 2;
                }
            }
        }
        
        return islands;
    }
}
