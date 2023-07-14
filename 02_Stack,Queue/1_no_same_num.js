//최초 풀이 (스택 자료구조 구현 후 해결)
function solution(arr) {
  class Stack {
    constructor() {
      this.arr = [];
    }
    push(item) {
      this.arr.push(item);
    }
    pop() {
      return this.arr.pop();
    }
    peek() {
      return this.arr[this.arr.length - 1];
    }
  }

  const answer = new Stack();
  arr.forEach((num) => {
    if (num !== answer.peek()) {
      answer.push(num);
    }
  });
  return answer.arr;
}
//새로운 풀이 (배열을 스택처럼 사용)
function solution(arr) {
  const answer = [];
  arr.forEach((num) => {
    if (num !== answer[answer.length - 1]) {
      answer.push(num);
    }
  });
  return answer;
}
