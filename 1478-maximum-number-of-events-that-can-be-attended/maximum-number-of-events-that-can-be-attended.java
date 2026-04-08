class Solution {
    public int maxEvents(int[][] events) {

       Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int i = 0, count = 0;
        int d = 0;
     
        while(i < n || !pq.isEmpty()){



            if(pq.isEmpty()){
                d = events[i][0];
            }
            
            while (i < n && events[i][0] == d) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
            
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
                d++;
            }
            
            if (pq.isEmpty() && i >= n) break;
        }

        return count;
    }
}