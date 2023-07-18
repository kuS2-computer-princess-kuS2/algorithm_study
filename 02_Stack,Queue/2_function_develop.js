function solution(progresses, speeds) {
  var r_date = [];
  let days = 0;
  for (var i = 0; i < progresses.length; i++) {
    days = Math.ceil((100 - progresses[i]) / speeds[i]);
    r_date.push(days);
  }
  var answer = [];
  let release = 1;
  for (var i = 0; i < r_date.length; i++) {
    for (var j = i + 1; j < r_date.length; j++) {
      if (r_date[i] >= r_date[j]) {
        release++;
      } else {
        break;
      }
    }
    answer.push(release);
    i = j - 1;
    release = 1;
  }
  return answer;
}
