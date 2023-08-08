function solution(brown, yellow) {
  for (let i = 1; i <= brown / 2; i++) {
    if (yellow % i == 0) {
      //약수
      width = yellow / i + 2;
      if (2 * (width + i) == brown) {
        return [width, i + 2];
      }
    }
  }
}
