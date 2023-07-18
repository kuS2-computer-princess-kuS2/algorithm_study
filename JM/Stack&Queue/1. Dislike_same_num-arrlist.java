//같은 숫자는 싫어 
//arraylist 사용해 풀이 
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        for(int num : arr){
            if(!stack.isEmpty()){
                if(stack.get(stack.size()-1)!=num) stack.add(num);
            } else stack.add(num);
        }
        
        int[] answer = stack.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
