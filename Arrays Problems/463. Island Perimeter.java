/*The intuition behind the solution is that whenever you encounter an island or 1, increase the perimter by 4, because at that time, we are checking only for
that single island's perimeter. After that, check whether the current island has any neighbouring island before it or not(in previous row and column).
If there exists any neighbour in previous rows and colums, decreement the perimeter by 2 sides respectvely, for each previous row and column, 
because, whenever we will merge 2 squares, we will lose 2 sides.*/


class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int perimeter = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                
                if(grid[i][j] == 1) {
                    
                    perimeter += 4;
                    
                    if(i > 0 && grid[i-1][j] == 1)
                        perimeter -= 2;
                    if(j > 0 && grid[i][j-1] == 1)
                        perimeter -= 2;
                }
            }
        }
        
        return perimeter;
    }
}
