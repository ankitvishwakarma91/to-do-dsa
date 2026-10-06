class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        if (n == 0)
            return 0;

        int count = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ch == ')') {
                st.pop();
            } else if (ch == '(') {
                st.push(ch);
            } else {
                count++;
            }
        }

        count += st.size();

        return count;
    }
}