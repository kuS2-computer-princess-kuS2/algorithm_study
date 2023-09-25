import java.util.*;

class Solution {
    int n, m;
    int[][] map_dp; 
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, 1, -1};
    
    public void check_value(int[][] maps, int i, int j){
        int cnt = map_dp[i][j]+1;
        
        for(int k=0;k<4;k++){
            int di = i+row[k];
            int dj = j+col[k];
            
            if(di>=0&&di<n&&dj>=0&&dj<m&&maps[di][dj]==1){
                if(map_dp[di][dj] > cnt || map_dp[di][dj] == 0){
                    map_dp[di][dj] = cnt;
                    check_value(maps, di, dj);
                }
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        map_dp = new int[n][m];
        
        map_dp[0][0] = 1;
        
        check_value(maps, 0, 0);
        
        if(map_dp[n-1][m-1] == 0) return -1;
        else return map_dp[n-1][m-1] ;
    }
}
