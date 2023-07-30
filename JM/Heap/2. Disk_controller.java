//디스크 컨트롤러
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //작업이 요청되는 시점기준으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0]; 
            }
        });
        
        //작업의 소요시간 순으로 정렬 후 같은 경우 요청 시점이 빠른 순 
        PriorityQueue<int[]> job_pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int answer = 0;
        int current_time = 0, idx = 0;
        int n = jobs.length; // 작업 개수
        while(true){
            while(idx<n){ // 요청 가능한 작업 추가 
                if(current_time>=jobs[idx][0]) job_pq.add(jobs[idx++]);
                else break;
            }
            
            if(job_pq.size()!=0){ 
                // 작업 진행
                int[] job = job_pq.peek();  job_pq.poll();
                current_time += job[1];
                answer += current_time - job[0];
            }
            else{ 
                if(idx>=n) break; // 종료
                else current_time = jobs[idx][0]; // 요청 시점이 가장 빠른 작업 접근
            }
        }
        
        return answer/n;
    }
}
