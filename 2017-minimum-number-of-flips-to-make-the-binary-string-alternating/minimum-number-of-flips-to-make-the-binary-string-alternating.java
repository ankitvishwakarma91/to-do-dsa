class Solution {
    public int minFlips(String s) {
        
        int  n = s.length();
        int count1 = 0;
        int count2 = 0;

        // This is not working 
        // for(int  i = 0; i<n; i++){
        //     char exp1 = (i % 2 == 0) ? '1' : '0';
        //     char exp2 = (i % 2 == 0) ? '0' : '1';

        //     if(s.charAt(i) != exp1) count1++;
        //     if(s.charAt(i) != exp2) count2++;
        // }


        // using sliding Window
        String str = s + s;
        int i = 0;
        int j = 0;

        char[] exp1 = new char[2 * n];
        char[] exp2 = new char[2 * n];

        for (int idx = 0; idx < 2 * n; idx++) {
            exp1[idx] = (idx % 2 == 0) ? '0' : '1';
            exp2[idx] = (idx % 2 == 0) ? '1' : '0';
        }
        int min = Integer.MAX_VALUE;
        while (j < 2 * n) {

            if (str.charAt(j) != exp1[j])
                count1++;
            if (str.charAt(j) != exp2[j])
                count2++;

            if (j - i + 1 > n) {
                if (str.charAt(i) != exp1[i])
                    count1--;
                if (str.charAt(i) != exp2[i])
                    count2--;
                i++;
            }
            if (j - i + 1 == n) {
                min = Math.min(min, Math.min(count1,count2));
            }
            j++;
        }
        return min;
    }
}