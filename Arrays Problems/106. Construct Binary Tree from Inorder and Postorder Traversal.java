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
    Map<Integer, Integer> map = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return InOrder(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    public TreeNode InOrder(int[] inorder, int[] postorder, int In_start, int In_end, int Post_index) {
        
        if(In_start > In_end)
            return null;
        
        TreeNode root = new TreeNode(postorder[Post_index]);
        
        if(In_start == In_end)
            return root;
        
        int Inroot = map.get(postorder[Post_index]);
        
        root.right = InOrder(inorder, postorder, Inroot + 1, In_end, Post_index - 1);
        root.left = InOrder(inorder, postorder, In_start, Inroot - 1, Post_index - (In_end - Inroot) - 1);
        
        return root;
    }
}
