class Solution {
    public int target_num(int[] numbers, int idx, int num, int target){
        int result = 0;
        if(idx==numbers.length)
            return (num == target)? 1:0;
        result += target_num(numbers, idx+1, num+numbers[idx], target);
        result += target_num(numbers, idx+1, num-numbers[idx], target);
        return result;
    }
    
    public int solution(int[] numbers, int target) {
        return target_num(numbers, 0, 0, target);
    }
}
