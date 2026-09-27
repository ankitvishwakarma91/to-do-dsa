class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i , map.getOrDefault(i, 0) + 1);
        }

        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        while(idx < n){

            for(int i : list){
                int count = map.get(i);
                if(count > 0){
                    ans[idx++] = i;
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        return ans;
    }
}