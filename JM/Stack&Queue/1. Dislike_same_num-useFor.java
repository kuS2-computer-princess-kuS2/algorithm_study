//같은 숫자는 싫어
//arrlist버전에서 arrayList -> arr로 변환하는 과정에서 for 반복문 사용하는것이 빠름 
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> stack = new ArrayList<>();
        for(int num : arr){
            if(!stack.isEmpty()){
                if(stack.get(stack.size()-1)!=num) stack.add(num);
            } else stack.add(num);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}
