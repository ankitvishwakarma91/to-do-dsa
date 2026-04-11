class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (!map.containsKey(nums[k])) {
                map.putIfAbsent(nums[k], new ArrayList<>());
            }
            map.get(nums[k]).add(k);



            if(map.get(nums[k]).size() >= 3){
                List<Integer> cur = map.get(nums[k]);
                int len = cur.size();
                int i = cur.get(len - 3);
                ans = Math.min(ans, k - i);
            }
        }


        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}