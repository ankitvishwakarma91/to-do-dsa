class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            int curr = nums[i];
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j * j <= curr; j++) {

                if (curr % j == 0) {
                    // if(j*j == curr){
                    //     count+=1;
                    // }else{
                    //     count+=2;
                    // }
                    list.add(j);
                    if (curr / j != j) {
                        list.add(curr / j);
                    }
                }
            }
            // System.out.println(list);

            if(list.size() == 4){
                for(int val : list){
                    sum+=val;
                }
            }
        }

        return sum;
    }
}