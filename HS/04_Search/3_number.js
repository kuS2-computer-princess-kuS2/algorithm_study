function solution(numbers) {
  var combination = numbers.split("");

  for (let i = 1; i < numbers.length; i++) {
    combination.forEach((set) => {
      for (let j = 0; j < numbers.length; j++) {
        if (numbers.indexOf(set) == j) continue;
        combination.push(set + numbers[j]);
      }
    });
  }
  console.log(Array.from(new Set(combination)));
}
