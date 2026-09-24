class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> at=new ArrayList<>();
        helper(ans,at,candidates,target,0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> at,int[] nums, int target,int idx){
        if(target<0 || idx==nums.length) return;
        if(target==0){
            ans.add(new ArrayList<>(at));
            return;
        }
        at.add(nums[idx]);
        helper(ans,at,nums,target-nums[idx],idx);
        at.remove(at.size()-1);
        helper(ans,at,nums,target,idx+1);
    }
}