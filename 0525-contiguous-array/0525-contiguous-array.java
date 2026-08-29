class Solution {
    public int findMaxLength(int[] nums) {
         HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int prefix = 0;

        int ans = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[i]==0)
                prefix--;
            else
                prefix++;

            if(map.containsKey(prefix)){

                ans=Math.max(ans,i-map.get(prefix));

            }else{

                map.put(prefix,i);
            }
        }

        return ans;
    }
}