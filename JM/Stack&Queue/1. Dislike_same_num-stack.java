//같은 숫자는 싫어
//stack 사용 - arrayList보다 이게 더 느림

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(!stack.empty()){
                if(stack.peek()!=num) stack.push(num);
            } else stack.push(num);
        }
        
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0; i--) {
            answer[i] = stack.peek();
            stack.pop();
        }

        return answer;
    }
}
