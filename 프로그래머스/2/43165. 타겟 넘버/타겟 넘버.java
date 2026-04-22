class Solution {
    
    static int[] nums;
    static int tgt;
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        nums = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = numbers[i];
        }
        tgt = target;
        
        dfs(0, 0);
        
        return count;
    }
    
    public void dfs(int idx, int sum){
        if(idx == nums.length){
            if(sum == tgt) count++;
            return;
        }
        dfs(idx+1, sum+nums[idx]);
        dfs(idx+1, sum-nums[idx]);
    }
}