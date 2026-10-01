class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        // int b1 = 0;
        // int b2 = 0;
        // int b3 = 0;

        // for(int i= 0; i<n ; i++){
        //     char ch = s.charAt(i);

        //     if(ch == '('){
        //         b1++;
        //     }else if(ch == ')'){
        //         b1--;
        //     }else if(ch == '{'){
        //         b2++;
        //     }else if(ch == '}'){
        //         b2--;
        //     }else if(ch == '['){
        //         b3++;
        //     }else{
        //         b3--;
        //     }
        // }

        // if(b2 < 0 || b3 < 0 || b1 < 0){
        //     return false;
        // }

        // return true;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if (ch == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if (ch == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}