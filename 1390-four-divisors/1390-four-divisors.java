class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            int curr = nums[i];
            int count = 0;
            // List<Integer> list = new ArrayList<>();
            int currSum = 0;
            for (int j = 1; j * j <= curr; j++) {

                if (curr % j == 0) {
                    int se = curr/j;
                    if(j*j == curr){
                        count+=1;
                        currSum += j;
                    }else{
                        count+=2;
                        currSum += se + j;
                    }
                    // list.add(j);
                    if (curr / j != j) {
                        // list.add(curr / j);
                    }
                }

                if (count > 4) {
                    break;
                }
            }

            // System.out.println(list);

            // if (list.size() == 4) {
            //     for (int val : list) {
            //         sum += val;
            //     }
            // }
            if (count == 4) {
                sum += currSum;
            }
        }

        return sum;
    }
}