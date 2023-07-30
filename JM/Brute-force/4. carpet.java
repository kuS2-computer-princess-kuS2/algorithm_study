//카펫
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //yellow = (w-2)*(y-2)
        //brown = w*h
        int w_plus_h = (brown+4)/2;
        int w=w_plus_h-3;
        while(true){
            int h=w_plus_h-w;
            if(w*h==brown+yellow){
                answer[0] = w;
                answer[1] = h; break;
            }
            w--;
        }
        return answer;
    }
}
