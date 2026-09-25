class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // Brute force
        // for (int i = 0; i <= s.length() - k; i += k) {

        //     String curr = s.substring(i, i + k);
        //     int sum = 0;
        //     for (char ch : curr.toCharArray()) {
        //         int val = ch - 'a';
        //         sum += val;
        //     }
        //     System.out.println("sum " + sum);
        //     int rem = sum % 26;

        //     System.out.print(rem);
        //     System.out.println((char) ('a' + rem));

        //     sb.append((char) ('a' + rem));
        // }

        int sum = 0;
        int count = 0;
        for(int i = 0; i < s.length() ; i++){
            sum += s.charAt(i) - 'a';
            count++;
            if(count == k){
                int rem = sum % 26;
                char ch = (char) ('a' + rem);
                sb.append(ch);
                sum = 0;
                count = 0;
            }
        }
        return sb.toString();
    }
}