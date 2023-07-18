function solution(s) {
  //배열에 추가대신 단순 cnt값으로 계산
  var cnt = 0;

  for (var i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      cnt++;
    } else {
      cnt--;
      if (cnt < 0) return false;
    }
  }
  return cnt == 0 ? true : false;
}
