//효율성 미통과,, 대체 왜?
function solution(s) {
  var stack = [];
  for (var i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      stack.push(s[i]);
    } else {
      if (stack.pop() === undefined) return false;
    }
  }
  return stack.length == 0 ? true : false;
}
