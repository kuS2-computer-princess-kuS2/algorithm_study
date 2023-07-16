//주식가격 

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> stack = new ArrayList<>(); // 가격 하락이 되지 않은 idx stack에 쌓기
        stack.add(0);
        for(int i=1;i<prices.length;i++){
            int last_idx = stack.get(stack.size()-1);
            while(prices[last_idx]>prices[i]){ // 가격 하락 
                answer[last_idx] = i - last_idx;
                stack.remove(stack.size()-1);
                if(stack.isEmpty()) break;
                last_idx = stack.get(stack.size()-1);
            }
            stack.add(i);
        }
        
        for(int i=0;i<stack.size();i++){
            answer[stack.get(i)] = (prices.length-1) - stack.get(i);
        }
        return answer;
    }
}
