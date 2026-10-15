// class Solution {
//     public boolean contains(TreeNode root,TreeNode x){
//         if(root==null) return false;
//         if(root==x) return true;
//         return contains(root.left,x) || contains(root.right,x);
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(p==root || q==root) return root;
//         if(p==q) return p;
//         boolean leftp=contains(root.left,p);
//         boolean rightq=contains(root.right,q);
//         if( (leftp && rightq) || (!leftp && !rightq) ) return root;
//         if(leftp && !rightq) return lowestCommonAncestor(root.left,p,q);
//         if(!leftp && rightq) return lowestCommonAncestor(root.right,p,q);
//         return root;
//     }
// } // It shows TLE on new testCase




class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p==root || q==root) return root;
        TreeNode Left=lowestCommonAncestor(root.left,p,q);
        TreeNode Right=lowestCommonAncestor(root.right,p,q);
        if(Left!=null && Right!=null) return root;
        else if(Left!=null) return Left;
        else return Right;
    }
}