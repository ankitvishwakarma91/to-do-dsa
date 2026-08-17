class Solution {
    public boolean isThree(int n) {

        // Sq. of prime no has exactly 3 factor

        if(n < 2) return false;

        // check perfect square 
        int root = (int) Math.sqrt(n);
        if(root * root != n){
            return false;
        }


        for(int i = 2 ; i * i <= root; i++){
            if(root % i == 0){
                return false;
            }
        }

        return true;
    }
}