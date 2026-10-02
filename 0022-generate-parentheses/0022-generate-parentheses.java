
class Solution {

    // public void solve(String curr, int len, int n, List<String> ans) {

    //     if (len == 2 * n) {
    //         if (isValid(curr)) {
    //             ans.add(curr);
    //         }
    //         return;
    //     }

    //     curr += '(';
    //     solve(curr, len + 1, n, ans);
    //     curr = curr.substring(0, curr.length() - 1);

    //     curr += ')';
    //     solve(curr, len + 1, n, ans);
    // }

    // public boolean isValid(String s) {

    //     int count = 0;

    //     for (char ch : s.toCharArray()) {
    //         if (ch == '(') {
    //             count += 1;
    //         } else {
    //             count -= 1;
    //         }
    //         if (count < 0) {
    //             return false;
    //         }
    //     }

    //     return count == 0;
    // }

    public void solve(String curr, int n , int open ,int close , List<String> ans){
        if(curr.length() == 2 * n){
            ans.add(curr);
            return;
        }

        if(open < n){
            // curr += '(';
            solve(curr + '(', n, open + 1 , close, ans);
           // curr.substring(0, curr.length() - 1);
        }

        if(close < open){
            // curr += ')';
            solve(curr + ')', n , open , close+1, ans);
           // curr.substring(0, curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        // solve("", 0, n, ans);
        solve("",n,0,0,ans);

        return ans;
    }
}