//기능개발

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> days = new ArrayList<>();
        int preday = (int)Math.ceil((100.0 - progresses[0])/speeds[0]);
        int cnt = 1; 
        for(int i = 1;i<progresses.length;i++){
            int day = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            if(preday<day){ // 배포 X 
                days.add(cnt);
                cnt = 1;
                preday = day;
            }
            else cnt++; // 함께 배포 가능 
        }
        days.add(cnt);
        
        //arraylist -> array
        int[] answer = new int[days.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = days.get(i);
        }
        return answer;
    }
}
