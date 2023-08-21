import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for(int l = 0; l < n ;l++){
            int i = commands[l][0]-1;
            ArrayList<Integer> sort_arr = new ArrayList<>();
            for(;i<commands[l][1];i++){
                sort_arr.add(array[i]);
            }
            Collections.sort(sort_arr);
            answer[l] = sort_arr.get(commands[l][2]-1);
            
        }
        return answer;
    }
}
