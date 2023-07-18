function solution(participant, completion) {
  // participant.sort();
  // completion.sort();
  // for (var i =0;i<completion.length;i++){
  //     if(participant[i]!==completion[i]) return participant[i];
  // }
  // return participant[completion.length];

  return participant.filter((fail) => !completion.includes(fail));
}
