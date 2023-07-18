function solution(clothes) {
  var kinds = new Object();
  var result = 1;
  clothes.forEach((cloth) => {
    if (!(cloth[1] in kinds)) {
      kinds[cloth[1]] = 1;
    } else {
      kinds[cloth[1]] += 1;
    }
  });
  for (combine in kinds) {
    result *= kinds[combine] + 1;
  }
  return result - 1;
}
