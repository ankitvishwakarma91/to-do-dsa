class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;

        int count = 0;
        // for (int i = 0; i < n - 2; i++) {
        //     // HashMap<Integer, Integer> map = new HashMap<>();
        //     int[] freq = new int[101];
        //     freq[nums[i]]++;
        //     // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        //     for (int j = i + 1; j < n; j++) {
        //         // map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        //         freq[nums[j]]++;
        //         for (int k = j + 1; k < n; k++) {
        //             // map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
        //             freq[nums[k]]++;
        //             if (nums[i] == nums[j] && nums[j] == nums[k]) {
        //                 // map.put(nums[i] , 3);
        //                 if (j - i == k - j && freq[nums[i]] == 3) {
        //                     count++;
        //                 }
        //             }
        //             freq[nums[k]]--;
        //             // map.remove(nums[k]);
        //         }
        //         // map.remove(nums[j]);
        //         freq[nums[j]]--;
        //     }
        // }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer,ArrayList<Integer>> na : map.entrySet()){
            int key = na.getKey();
            ArrayList<Integer> list = na.getValue();
            if(list.size() == 3){
                int first = list.get(0);
                int sec = list.get(1);
                int th = list.get(2);
                if(sec - first == th - sec){
                    count++;
                }
            }
        }

        return count;
    }
}