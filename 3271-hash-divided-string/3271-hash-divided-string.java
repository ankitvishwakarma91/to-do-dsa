class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= s.length() - k; i += k) {

            String curr = s.substring(i, i + k);
            int sum = 0;
            for (char ch : curr.toCharArray()) {
                int val = ch - 'a';
                sum += val;
            }
            System.out.println("sum " + sum);
            int rem = sum % 26;

            System.out.print(rem);
            System.out.println((char) ('a' + rem));

            sb.append((char) ('a' + rem));
        }

        return sb.toString();
    }
}