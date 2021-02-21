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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //Iterative Method
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        if(root == null)
            return nodes;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        stack.push(curr);
        
        while(!stack.isEmpty()) {
            
            curr = stack.pop();
            nodes.add(curr.val);
            
            if(curr.right != null)
                stack.push(curr.right);
            
            if(curr.left != null)
                stack.push(curr.left);
            
        }
        
        return nodes;
    }
}

/* Both recursive solutions but with little different approaches
 List<Integer> nodes = new ArrayList<Integer>();
        
        if(root == null)
            return nodes;
        
        
        nodes.add(root.val);
        
        nodes.addAll(preorderTraversal(root.left));
        nodes.addAll(preorderTraversal(root.right));
        
        return nodes;

*/

/*
 public List<Integer> preorderTraversal(TreeNode root) {
 
        List<Integer> nodes = new ArrayList<Integer>();
        helper(root, nodes);
        return nodes;
    }
    
    public void helper(TreeNode root, List<Integer> nodes) {
    
        if(root == null)
            return null;
            
        nodes.add(root.val);
        
        helper(root.left, nodes);
        helper(root.right, nodes);
    }
}
*/
