class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int patern1  = 0;
        int partern2 = 0;

        for(int i = 0 ;i<n; i++){
            // if even idx
            char acutal = (i % 2 == 0) ? '0' : '1';
            char acutal2 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != acutal) patern1++;
            if(s.charAt(i) != acutal2) partern2++;
        }

        return Math.min(patern1,partern2);
        
    }
}