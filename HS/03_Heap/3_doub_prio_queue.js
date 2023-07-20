function solution(operations) {
  var p_queue = [];
  operations.forEach((op) => {
    op = op.split(" ");
    switch (op[0]) {
      case "I":
        p_queue.push(parseInt(op[1]));
        p_queue.sort(function (a, b) {
          //내림차순 정렬
          return b - a;
        });
        break;
      case "D":
        if (!p_queue.length) {
          break;
        }
        if (op[1] == 1) {
          //최댓값 삭제
          p_queue.shift();
        } else {
          //최소값 삭제
          p_queue.splice(p_queue.length - 1, 1);
        }
    }
  });
  if (!p_queue.length) {
    return [0, 0];
  } else {
    return [p_queue[0], p_queue[p_queue.length - 1]];
  }
}
