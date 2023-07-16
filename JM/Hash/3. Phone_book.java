//전화번호 목록
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> pmap = new HashMap<String, Integer>();
        for(String phone_num : phone_book){
            pmap.put(phone_num, 1);
        }
        
        boolean answer = true;
        for(String phone_num : phone_book){
            for(int i=1;i<phone_num.length();i++){
                String temp_pnum = phone_num.substring(0, i);
                if(pmap.containsKey(temp_pnum)) return false;
            }
        }
        return answer;
    }
}
