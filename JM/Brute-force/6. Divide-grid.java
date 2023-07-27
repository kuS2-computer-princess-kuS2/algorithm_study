//전력망을 둘로 나누기
class Solution {
    int[][] connect;
    public int check(int n, int idx){
        int cnt = 1;
        for(int i=1;i<101;i++){
            if(connect[idx][i]==1){
                connect[idx][i]=0;  connect[i][idx]=0;
                cnt += check(n, i);
                connect[idx][i]=1;  connect[i][idx]=1;
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        connect = new int[101][101];
        for(int[] wire : wires){
            connect[wire[0]][wire[1]]=1;
            connect[wire[1]][wire[0]]=1;
        }
        
        for(int[] wire : wires){
            connect[wire[0]][wire[1]]=0;
            connect[wire[1]][wire[0]]=0;
            int temp = check(n, wires[0][0]);
            temp = (2*temp-n>0)? 2*temp-n: n-2*temp;
            answer = (answer>temp)? temp:answer; 
            connect[wire[0]][wire[1]]=1;
            connect[wire[1]][wire[0]]=1;
        }
        
        return answer;
    }
}
