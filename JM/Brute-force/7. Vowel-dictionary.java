//모음사전
import java.util.*;

class Solution {
    ArrayList<String> dic = new ArrayList<>();
    String[] vowel = {"A","E","I","O","U"};
    
    public void make_dic(int len, String word){
        if(len==5) return;
        for(int i = 0;i<5;i++){
            dic.add(word + vowel[i]);
            make_dic(len+1, word + vowel[i]);
        }    
    }
    
    public int solution(String word) {
        make_dic(0, "");
        
        return dic.indexOf(word)+1;
    }
}
