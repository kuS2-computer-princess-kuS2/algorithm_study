function solution(word) {
  const vowel = ["A", "E", "I", "O", "U"];
  index = 1;
  for (let i = 0; i < 5; i++) {
    if (word[i] == null) index *= 5;
    index *= vowel.indexOf(word[i]) + 1;
  }
  return index;
}
