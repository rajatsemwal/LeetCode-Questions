/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    
        //Iterative solution

        List<Integer> nodes = new ArrayList<Integer>();
        
        if(root == null)
            return nodes;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        stack.push(curr);
        
        while(!stack.isEmpty()) {
            
            curr = stack.pop();
            nodes.add(0, curr.val);
            
            if(curr.left != null)
                stack.push(curr.left);
            
            if(curr.right != null)
                stack.push(curr.right);
        }
        
        return nodes;
    }
}


/*      
       // Recursive solution
        List<Integer> nodes = new ArrayList<Integer>();
        
        helper(root, nodes);
        return nodes;
    }
    
    public void helper(TreeNode root, List<Integer> nodes) {
        
        if(root != null) {
            
            helper(root.left, nodes);
            helper(root.right, nodes);
            
            nodes.add(root.val);
*/
