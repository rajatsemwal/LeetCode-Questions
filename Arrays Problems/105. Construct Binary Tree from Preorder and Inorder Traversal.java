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
    HashMap<Integer, Integer> map = new HashMap<>();
    int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int In_start, int In_end) {
        if(In_start > In_end)
            return null;
        
        TreeNode root = new TreeNode(preorder[preindex++]);
        
        if(root == null)
            return null;
        
        if(In_start == In_end)
            return root;
        
        int In_index = map.get(root.val);
        
        root.left = build(preorder, inorder, In_start, In_index - 1);
        root.right = build(preorder, inorder, In_index + 1, In_end);
        
        return root;
    }
}

// This is the another approach, using without HashMap
/*
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildtree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    
    public TreeNode buildtree(int[] inorder, int[] preorder, int in_start, int in_end, int pre_start, int pre_end) {
        if(in_start > in_end)
            return null;
        
        
        int rootindex = -1;
        for(int i = in_start; i <= in_end; i++) {
            if(inorder[i] == preorder[pre_start]) {
                rootindex = i;
                break;
            }
        }
        
        int lpreS = pre_start + 1;
        int linS = in_start;
        int linE = rootindex - 1;
        int lpreE = linE - linS + lpreS;
        int rpreS = lpreE + 1;
        int rpreE = pre_end;
        int rinS = rootindex + 1;
        int rinE = in_end;
        
        TreeNode root = new TreeNode(preorder[pre_start]);
        
        root.left = buildtree(inorder, preorder, linS, linE, lpreS, lpreE);
        root.right = buildtree(inorder, preorder, rinS, rinE, rpreS, rpreE);
        
        return root;
    }
}*/
