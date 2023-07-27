//피로도
import java.util.*;

class Solution {
    boolean[] visit;
    int answer = 0;
    
    public void explore(int k, int cnt, int n, int[][] dungeons, int idx){
        int i = idx;
        for(int j=0;j<n;j++,i++){
            if(cnt>answer) answer = cnt;
            i %= n;
            if(!visit[i] && k>=dungeons[i][0]){
                visit[i] = true;
                explore(k-dungeons[i][1], cnt+1, n, dungeons, i);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        Arrays.fill(visit, false);
        explore(k, 0, dungeons.length, dungeons, 0);
        return answer;
    }
}
