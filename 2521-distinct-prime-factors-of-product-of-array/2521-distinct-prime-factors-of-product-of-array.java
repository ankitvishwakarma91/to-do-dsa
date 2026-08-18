class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<n; i++){


            int curr = nums[i];

            for(int j = 2 ; j * j <= curr ; j++){
                if(curr % j == 0){

                    set.add(j);

                    while(curr % j == 0){
                        curr /=j;
                    }
                }
            }

            if(curr > 1){
                set.add(curr);
            }
        }

        return set.size();
    }
}