function solution(k, dungeons) {
  function require_sort(dungeons) {
    return dungeons.sort(function (a, b) {
      return b[0] - a[0];
    });
  }
  function useage_sort(dungeons) {
    return dungeons.sort(function (a, b) {
      return a[1] - b[1];
    });
  }

  //const dungeon_copy=dungeons.slice();

  while (k > 0) {
    require_sort(dungeons);
    start = dungeons.shift();

    if (k - start[1] < dungeons[0]) {
      //next 먼저
      var exec = dungeons.shift();
      console.log(exec);
      k -= exec[1];
      dungeons.splice(0, 0, start);
    } else {
      var exec = dungeons.shift();
      k -= exec[1];
    }
  }
}
