class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        Arrays.sort(nums1);

        boolean isAllEven = true;
        boolean isAllOdd = true;

        for(int i : nums1){
            if(i % 2 != 0){
                isAllEven = false;
                
            }else{
                isAllOdd = false;
            }
        }
        // for(int i : nums1){
        //     if(i % 2 == 0){
        //         isAllOdd = false;
        //         break;
        //     }
        // }

        System.out.println(isAllEven);
        System.out.println(isAllOdd);

        if(isAllEven || isAllOdd){
            return true;
        }else{

            boolean seenOdd = false;

            for(int i = 0; i < n ; i++){
                if(nums1[i] % 2 == 0 && !seenOdd){
                    return false;
                }else{
                    seenOdd = true;
                }
            }

        }

        return true;
    }
}