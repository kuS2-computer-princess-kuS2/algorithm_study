import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for(int i=n;i>=0;i--){
            int h = 0;
            for(int j=n-1;j>=0;j--){
                if(i<=citations[j]) h++;
                else break;
            }
            if(h>=i) return i;
        }
        return answer;
    }
}
