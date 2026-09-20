class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            int val = 'z' - ch + 1;

            // System.out.println("val : " + val);

            sum += (i + 1 ) * val;
        }
        return sum;
    }
}