//더 맵게
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scoville_pq = new PriorityQueue<>();
        
        for(int scovill : scoville){
            scoville_pq.add(scovill);
        }
        
        while(scoville_pq.peek()<K){
            answer++;
            
            if(scoville_pq.size()==1) return -1;
            int a = scoville_pq.peek(); scoville_pq.poll();
            int b = scoville_pq.peek()*2; scoville_pq.poll();
            
            scoville_pq.add(a+b);
        }
        
        return answer;
    }
}
