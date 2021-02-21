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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //Recursive solution
        List<Integer> nodes = new ArrayList<Integer>();
        
        helper(root, nodes);
        return nodes;
    }
    
    public void helper(TreeNode root, List<Integer> nodes) {
        
        TreeNode curr = root;
        
        if(curr != null) {
            
            if(curr.left != null)
                helper(root.left, nodes);
            
            nodes.add(curr.val);
            
            if(root.right != null)
                helper(root.right, nodes);
        }
    }
}

/*
List<Integer> nodes = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            
            while(curr != null) {
                
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            nodes.add(curr.val);
            curr = curr.right;
        }
        
        return nodes;
*/
