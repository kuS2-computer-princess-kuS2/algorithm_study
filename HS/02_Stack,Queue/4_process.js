function solution(priorities, location) {
  queue = [];
  execute = new Object();
  order = 0;
  for (var i = 0; i < priorities.length; i++) {
    queue.push(i);
  }
  var p_num = 0;
  var q_num = 0;
  while (true) {
    p_num = priorities.shift();
    q_num = queue.shift();
    for (const p of priorities) {
      if (p > p_num) {
        console.log(p, p_num);
        queue.push(q_num);
        priorities.push(p_num);
        break;
      }
    }
    console.log(queue);
    if (!queue.includes(q_num)) {
      order++;
      console.log(order);
      if (q_num == location) return order;
    }
  }
}
