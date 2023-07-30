//이중우선순위큐

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int size = 0; 
        PriorityQueue<Integer> pq_low = new PriorityQueue<>(); // 낮은 순 정렬
        PriorityQueue<Integer> pq_high = new PriorityQueue<>(Collections.reverseOrder()); //높은 순 정렬 
        
        for(String op : operations){
            if(op.equals("D 1")){ // 최댓값 삭제 
                if(size!=0){
                    size--; pq_high.poll();
            }}
            else if(op.equals("D -1")){ // 최솟값 삭제
                if(size!=0){
                    size--; pq_low.poll();
            }}
            else{ // 숫자 삽입
                size++;
                int num =  Integer.parseInt(op.substring(2));
                pq_low.add(num); pq_high.add(num);
            }
        }
        
        if(size == 0){
            answer[0] = 0; answer[1] = 0;
        }
        else{
            HashSet<Integer> pq = new HashSet();
            pq.addAll(pq_high);
            pq.retainAll(pq_low); // 교집합
            
            //최댓값
            while(pq_high.size()!=0){
                if(pq.contains(pq_high.peek())){ //삭제여부 확인
                    answer[0] = pq_high.peek(); break;
                }
                else pq_high.poll();
            }
            
            //최솟값
            while(pq_low.size()!=0){
                if(pq.contains(pq_low.peek())){ //삭제여부 확인
                    answer[1] = pq_low.peek(); break;
                }
                else pq_low.poll();
            }
        }
        return answer;
    }
}
