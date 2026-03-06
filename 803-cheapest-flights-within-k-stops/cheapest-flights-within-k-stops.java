class Solution {

    public int dijkstra( ArrayList<ArrayList<int[]>> adj , int n , int[][] flights,  int src, int dst, int k ){
        
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // {stop, dist,start}
        pq.add(new int[]{0,0,src});
        dist[src] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int stop = curr[0];
            int d = curr[1];
            int node = curr[2];

            if(stop > k) continue;
            // if(node == dst && k == -1)  return dist[node];

            for(int[] neighbour : adj.get(node)){
                int v = neighbour[0];
                int w = neighbour[1];
                // k--;
                if(d + w < dist[v]){
                    dist[v] = d+w;
                    pq.add(new int[]{stop + 1,dist[v],v});
                }
            }            
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ad : flights){
            int u = ad[0];
            int v = ad[1];
            int price = ad[2];

            adj.get(u).add(new int[]{v,price});
        }

        return dijkstra(adj,n,flights,src,dst,k);
    }
}