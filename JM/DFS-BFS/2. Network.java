import java.util.*;
class Solution {
    boolean[] conn; 
    boolean[][] check;
    int answer = 0;
    public void find_conn(int n,int[][] computers, int stand){
        for(int i= 0;i < n;i++){
            if(i!=stand){
                if((computers[stand][i] == 1) && (check[stand][i] == false)){
                    conn[i] = true;
                    check[stand][i] = true; check[i][stand] = true;
                    find_conn(n, computers, i);
                }
            }
        }
        
    }
    
    public int solution(int n, int[][] computers) { 
        conn = new boolean[n];
        Arrays.fill(conn, false);
        check = new boolean[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(check[i], false);
        for(int i=0;i<n;i++){
            if(!conn[i]){
                conn[i] = true;
                find_conn(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
}
