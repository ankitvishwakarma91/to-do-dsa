class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        String f = s + s;

        System.out.println(f);

        int count = 0;

        for(int i = 0; i < s.length() ; i++){
            int cur = 0;
            for(int j = i + 1; j < i + n ; j++){

                if(f.charAt(j) == f.charAt(j-1)){
                    cur++;
                }
            }
            if(cur == k) count++;
        }

        return count;
    }
}