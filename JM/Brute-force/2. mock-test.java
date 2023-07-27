//모의고사
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] supoza1 = {1, 2, 3, 4, 5};
        int[] supoza2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoza3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=1;i<=3;i++){
            int correct = 0;
            int[] supoza;
            if(i==1) supoza = supoza1;
            else if(i==2) supoza = supoza2;
            else supoza = supoza3;
            int idx = 0;
            for(int answer : answers){
                if(answer == supoza[idx++]) correct++;
                idx %= supoza.length;
            }
            map.put(i, correct);
        }
        
        int max = 0;
        for(int i=1;i<=3;i++){
            if(max<map.get(i)){
                max = map.get(i);
                arr.clear();
                arr.add(i);
            }
            else if(max==map.get(i)) arr.add(i);
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = arr.get(i);
        }

        
        return answer;
    }
}
