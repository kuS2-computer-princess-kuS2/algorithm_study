//최소직사각형
class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h =0; //w가 더 크다고 가정
        for(int[] size : sizes){
            int temp_w = (size[0]>size[1])? size[0]:size[1];
            int temp_h = (size[0]>size[1])? size[1]:size[0];
            
            w = (temp_w>w)? temp_w:w;
            h = (temp_h>h)? temp_h:h;
            
        }
        return w*h;
    }
}
