class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int prefix_sum = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix_sum += nums[i];
            int remove = prefix_sum - k;
            if(map.containsKey(remove)){
                cnt+=map.get(remove);
            }
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0)+1);
        }
        return cnt;
    }
}