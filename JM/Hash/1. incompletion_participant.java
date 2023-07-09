//완주하지 못한 선수 
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //완주자 map에 저장
        Map<String, Integer> cmap = new HashMap<String, Integer>();
        for(String cname : completion){
            if(cmap.containsKey(cname))
                cmap.replace(cname, cmap.get(cname)+1);
            else cmap.put(cname, 1);
        }
        
        // 미완주자 확인
        String answer = "";
        for(String pname : participant){
            if(cmap.containsKey(pname)){ // 완주자
                int cvalue = cmap.get(pname);
                if(cvalue>0) {
                    if(cvalue-1==0) cmap.remove(pname);
                    else cmap.replace(pname, cvalue-1);
                }
            }
            else  answer += pname; // 미완주자

        }
        return answer;
    }
}
