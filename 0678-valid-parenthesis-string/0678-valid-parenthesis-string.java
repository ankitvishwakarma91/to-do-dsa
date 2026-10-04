class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> astrick = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                openBracket.push(i);
            }else if (ch == '*') {
                astrick.push(i);
            }else{

                if (!openBracket.isEmpty()) {
                    openBracket.pop();
                }else if (!astrick.isEmpty()) {
                    astrick.pop();
                }else{
                    return false;
                }
            }

        }

        while (!openBracket.isEmpty()) {
            if (astrick.isEmpty()) {
                return false;
            }
            int openIdx = openBracket.pop();
            int closeIdx = astrick.pop();
            if (openIdx > closeIdx) {
                return false;
            }
        }

        return openBracket.isEmpty();
    }
}