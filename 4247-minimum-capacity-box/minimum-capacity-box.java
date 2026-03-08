class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {

        int n = capacity.length;
        int min = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(capacity[i] >= itemSize){
                min = Math.min(min,capacity[i]);
                minIdx = i;
            }
        }   
        // int minIdx = 0;
        for(int i = 0; i<n; i++){
            if(min == capacity[i]){
                minIdx = Math.min(minIdx,i);
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}