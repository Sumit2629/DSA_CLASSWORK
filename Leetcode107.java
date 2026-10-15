class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> at=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                at.add(x.val);
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
            ans.add(0,at);
        }
        return ans;
    }
}