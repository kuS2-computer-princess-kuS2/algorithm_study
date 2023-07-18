function solution(nums) {
  var size = nums.length / 2;
  var kinds = new Set(nums);
  return kinds.size < size ? kinds.size : size;
}
