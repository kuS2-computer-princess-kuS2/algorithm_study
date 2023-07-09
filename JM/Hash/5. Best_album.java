//베스트앨범
import java.util.*;

class PlayInfo implements Comparable<PlayInfo>{
    int idx;
    int num;
    
    public PlayInfo(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
    
    @Override
    public String toString() {
        return "{idx: " + idx+", num: "+num+"}";
    }
    
    @Override
    public int compareTo(PlayInfo p_info) {
        return p_info.num - this.num;
    }
}

class GenreInfo implements Comparable<GenreInfo> {
    ArrayList<PlayInfo> g_plays = new ArrayList<>(); 
    int sum = 0; 
    
    public GenreInfo(PlayInfo play){
        this.g_plays.add(play);
        this.sum = play.num;
    }
    
    public void updateInfo(PlayInfo play){
        this.g_plays.add(play);
        this.sum += play.num;
        Collections.sort(g_plays); // 재생수 기준 정렬 
    }
    
    public int getSize(){
       return this.g_plays.size(); 
    }
    
    public int getPlayIdx(int idx){
        return this.g_plays.get(idx).idx;
    }
    
    @Override
    public String toString() {
        return "{sum: " + sum+", plays: "+g_plays+"}";
    }
    
    @Override
    public int compareTo(GenreInfo g_info) {
        return g_info.sum - this.sum;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르별 플레이리스트 정리
        Map<String, GenreInfo> genre_map = new HashMap<String, GenreInfo>();
        for(int i=0;i<plays.length;i++){
            String genre = genres[i];
            int play = plays[i];
            if(genre_map.containsKey(genre)){
                GenreInfo g_info = genre_map.get(genre);
                g_info.updateInfo(new PlayInfo(i, play));
            }
            else{
                GenreInfo g_info = new GenreInfo(new PlayInfo(i, play));
                genre_map.put(genre, g_info);
            }
        }
        
        //재생 기준 정렬
        List<Map.Entry<String, GenreInfo>> entryList = new LinkedList<>(genre_map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        
        //노래 수록 
        List<Integer> answerList = new ArrayList<Integer>(); 
        for(Map.Entry<String, GenreInfo> entry : entryList){
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
            GenreInfo g_info = entry.getValue();
            for(int i=0;i<2&&i<g_info.getSize();i++){
                answerList.add(g_info.getPlayIdx(i));
            }
        }
        
        //arraylist -> array
        int[] answer = answerList.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}
