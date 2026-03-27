class Solution {

    public int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i<= n ; i++){
            ans[i] = countSetBits(i);
        }
        return ans;
    }
}