class Solution {
    
    int[] check;
    int answer = 0;
    int temp_answer = 0;
    public int diff(String str1, String str2){
        int cnt = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) cnt++;
        }
        return cnt;
    }
    
    public void find(String target, String[] words, String stand, int idx){
        if(idx!=-1) {
            check[idx] = 1;
            temp_answer++;   
        }
        
        if(stand.equals(target)) {
            if(answer == 0 || temp_answer < answer)
                answer = temp_answer;
        }
        else{
            for(int i=0;i<words.length;i++){
                if(check[i] == 0){
                    if(diff(stand, words[i])==1){
                        find(target, words, words[i], i);
                    }    
                }
            }    
        }
        
        if(idx!=-1){
            check[idx] = 0; 
            temp_answer--;  
        } 
    }
    
    public int solution(String begin, String target, String[] words) {
        check = new int[words.length];
        
        find(target, words, begin, -1);
        return answer;
    }
}
