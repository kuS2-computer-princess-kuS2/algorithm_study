function solution(answers) {
  const supo = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];

  var rank = [0, 0, 0];

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < answers.length; j++) {
      if (supo[i][j % supo[i].length] == answers[j]) {
        rank[i] += 1;
      }
    }
  }

  let max = Math.max(...rank);
  var answer = [];
  for (let i = 0; i < 3; i++) {
    if (rank[i] == max) answer.push(i + 1);
  }
  return answer;
}
