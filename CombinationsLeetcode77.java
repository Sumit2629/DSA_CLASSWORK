class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> at=new ArrayList<>();
        helper(n,k,ans,at,1);
        return ans;
    }
    public void helper(int n, int k,List<List<Integer>> ans,List<Integer> at,int i){
        if(at.size()==k){
            ans.add(new ArrayList<>(at));
            return;
        }
        if(i>n) return;
            at.add(i);
            helper(n,k,ans,at,i+1);
            at.remove(at.size()-1);
            helper(n,k,ans,at,i+1);
    }
}