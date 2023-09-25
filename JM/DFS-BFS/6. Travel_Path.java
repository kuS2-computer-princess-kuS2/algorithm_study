import java.util.*;

class Solution {
    int[] check;
    int cnt;
    List<String[]> answer_arr = new ArrayList<>(); 
    String[] temp_answer;
    
    public void find(String[][] tickets, int idx){
        temp_answer[cnt] = tickets[idx][0];
        check[idx] = 1; cnt++;
        
        if(cnt == tickets.length) {
            temp_answer[cnt] = tickets[idx][1];
            String[] find_answer = new String[temp_answer.length];
            System.arraycopy(temp_answer, 0, find_answer, 0, temp_answer.length);
            answer_arr.add(find_answer);
        }
        else {
            String des = tickets[idx][1];
            for(int i=0;i<tickets.length;i++){
                if(tickets[i][0].equals(des) && check[i]==0){
                    find(tickets, i);     
                }   
            }   
        }
        
        check[idx] = 0;
        cnt--;
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        check = new int[tickets.length];
        temp_answer = new String[tickets.length+1];
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")) {
                cnt = 0;
                find(tickets, i);
            }
        }
    
        //정렬
        Collections.sort(answer_arr, new Comparator<String[]>(){
            @Override
            public int compare(String[] str_arr1, String[] str_arr2){
                int res = 0;
                for(int i=0;i<str_arr1.length;i++){
                    res = str_arr1[i].compareTo(str_arr2[i]);
                    if(res!=0) break; 
                }
                return res;
            }
        });
        
        
        return answer_arr.get(0);
    }
}
