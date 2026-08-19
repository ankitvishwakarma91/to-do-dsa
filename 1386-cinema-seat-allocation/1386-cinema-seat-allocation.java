class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] rs : reservedSeats) {
            int row = rs[0];
            int seat = rs[1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(seat);
        }

        // all empty row and it has max 2 group can seat
        int ans = (n - map.size()) * 2;

        // groupA = 2,3,4,5
        // groupB = 4,5,6,7
        // groupC = 6,7,8,9

        for (Map.Entry<Integer, HashSet<Integer>> iterate : map.entrySet()) {

            int key = iterate.getKey();
            List<Integer> curr = iterate.getValue().stream().collect(Collectors.toList());

            // for (int val : curr) {
            //     System.out.print("Key : " + key + " value : " + val +"\n");
            // }

            boolean groupA = curr.contains(2) || curr.contains(3) || curr.contains(4) || curr.contains(5);
            boolean groupB = curr.contains(4) || curr.contains(5) || curr.contains(6) || curr.contains(7);
            boolean groupC = curr.contains(6) || curr.contains(7) || curr.contains(8) || curr.contains(9);

            if (!groupA && !groupC) {
                ans += 2;
            } else if (!groupA || !groupB || !groupC) {
                ans += 1;
            }
        }

        return ans;
    }

    // public boolean isAvailable(int rq , List<Integer> list){
    //     for(int i : list){
    //         if(list.contains)
    //     }
    // }
}