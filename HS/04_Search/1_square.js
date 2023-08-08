function solution(sizes) {
  var w_max = [];
  var h_max = [];

  for (var i = 0; i < sizes.length; i++) {
    if (sizes[i][0] > sizes[i][1]) {
      w_max.push(sizes[i][0]);
      h_max.push(sizes[i][1]);
    } else {
      w_max.push(sizes[i][1]);
      h_max.push(sizes[i][0]);
    }
  }
  let width = w_max.sort(function (a, b) {
    return b - a;
  })[0];
  let height = h_max.sort(function (a, b) {
    return b - a;
  })[0];
  return width * height;
}
