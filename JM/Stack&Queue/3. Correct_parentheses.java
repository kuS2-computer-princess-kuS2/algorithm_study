//올바른 괄호 
import java.util.*;

class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='(') cnt++;
            else { // ch == ')'
                if(--cnt<0) return false; // () 짝이 안맞는 경우 
            }
        }
        if(cnt==0)  return true;
        else return false; // (가 더 많은 경우 
    }
}
