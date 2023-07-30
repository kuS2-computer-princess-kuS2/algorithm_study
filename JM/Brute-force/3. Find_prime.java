//소수찾기
import java.util.*;

class Solution {
    boolean[] prime = new boolean[10000000];
    int answer = 0;
    public void make_number(int length, String num, int[] numbers){
        
        if(length == num.length()){
            if(prime[Integer.parseInt(num)])
                answer++;
            else return ;
        }
        
        for(int i=0;i<10;i++){
            if(num.length()==0&&i==0) i++;
            if(numbers[i]>0){
                numbers[i]--;
                num += Integer.toString(i);
                make_number(length, num, numbers);
                numbers[i]++;
                num = num.substring(0, num.length()-1);
            }
        }
    }
    
    public int solution(String numbers) {
        Arrays.fill(prime, true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<prime.length;i++){
            if(prime[i]){
                for(int j=2;i*j<10000000;j++){
                    prime[i*j] = false;
                }
            }
        }
        
        int[] number = new int[10];
        Arrays.fill(number, 0);
        for(int i=0;i<numbers.length();i++){
            number[numbers.charAt(i)-'0']++;
        }
        
        for(int i=1;i<=numbers.length();i++){
            make_number(i, "", number);
        }
        return answer;
    }
}
