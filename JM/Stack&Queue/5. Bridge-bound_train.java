//다리를 지나는 트럭 
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0, current_time = 0; // 현재 다리에 있는 트럭 합계, 경과 시간 
        ArrayList<Integer> truck_queue = new ArrayList<>(); // 현재 다리를 건너는 트럭
        ArrayList<Integer> time_queue = new ArrayList<>(); // 다리를 건너기 시작한 시간 
        
        for(int i=0; i<truck_weights.length;i++){
            int tweight = truck_weights[i];
            //현재 트럭이 다리를 못 지나갈 경우 
            while(sum+tweight> weight || truck_queue.size()==bridge_length){
                sum -= truck_queue.get(0);
                current_time += bridge_length-(current_time-time_queue.get(0))-1;
                truck_queue.remove(0);  time_queue.remove(0);
            }   // 건널 수 있는 시점까지 진행시키기
            
            //다리를 건너는 트럭 추가
            sum += tweight;
            truck_queue.add(tweight);
            time_queue.add(++current_time);
            
            if(!time_queue.isEmpty()){ // 시간이 지남에 따라 자동으로 건너기 완료한 트럭 삭제     
            if(current_time - time_queue.get(0)==bridge_length){
                sum -= truck_queue.get(0);
                truck_queue.remove(0);  time_queue.remove(0);
            }}
        }
        
        if(!time_queue.isEmpty()) // 마지막으로 남은 트럭 시간 계산 
            current_time += bridge_length-(current_time-time_queue.get(time_queue.size()-1));
        return current_time;
    }
}
