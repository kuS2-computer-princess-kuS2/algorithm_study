function solution(genres, plays) {
  var m_list = [];
  for (var i = 0; i < genres.length; i++) {
    m_list[i] = new Object({
      num: i,
      genre: genres[i],
      play: plays[i],
    });
  }

  var rank = new Object();

  m_list.forEach((m) => {
    if (!Object.keys(rank).includes(m.genre)) {
      rank[`${m.genre}`] = m.play;
    } else {
      rank[`${m.genre}`] += m.play;
    }
  });

  let filter_rank = [];
  for (var gen in rank) {
    filter_rank.push([gen, rank[gen]]);
  }

  filter_rank = filter_rank.sort(function (a, b) {
    return b[1] - a[1];
  });

  let result = [];

  filter_rank.forEach((genre) => {
    let filter_genre = m_list.filter((m) => m.genre === genre[0]);
    filter_genre = filter_genre.sort(function (a, b) {
      return b.play - a.play;
    });
    result.push(filter_genre[0].num);
    if (filter_genre[1]) {
      result.push(filter_genre[1].num);
    }
  });

  return result;
}
