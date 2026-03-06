class Solution {

    // public List<Integer> topo(int n , ArrayList<ArrayList<Integer>> adj ){

    // }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] inorder = new int[n];
        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            inorder[v]++;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(inorder[i] == 0){
                q.add(i);
                ans.add(i);
            }
        }

        return ans;
    }
}