//의상
import java.util.*;

class Solution {
    public int[] cnum = new int[30];
    
    public int solution(String[][] clothes) {
        Map<String, Integer> cmap = new HashMap<String, Integer>();
        Arrays.fill(cnum, 1);
        for(String[] cloth : clothes){
            String cloth_sort = cloth[1];
            if(!cmap.containsKey(cloth_sort))
                cmap.put(cloth_sort, cmap.size());
            cnum[cmap.get(cloth_sort)]++;
        }
        
        int answer = 1;
        for(int i=0;i<cmap.size();i++){
            answer *= cnum[i];
        }
        return answer-1;
    }
}
