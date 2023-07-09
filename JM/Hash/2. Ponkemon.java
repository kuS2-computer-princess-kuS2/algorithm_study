//폰켓몬
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> nmap = new HashMap<Integer, Integer>();
        for(int num : nums){
            //if(!nmap.containsKey(num))
                nmap.put(num, 1);
        }
        
        int answer = 0;
        int n = nums.length/2;
        int m = nmap.size();
        if(m<n) answer = m;
        else answer = n;
        return answer;
    }
}
