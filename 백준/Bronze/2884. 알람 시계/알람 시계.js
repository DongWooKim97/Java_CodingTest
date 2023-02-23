const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

input = input[0];
// console.log(input, input[0]);

input = input.split(' ').map((item) => +item);
solution(input[0], input[1]);
// console.log(input);
// input = input.map((item) => +item);
// solution(input[0]);


function solution(A, B) {
  var h = 23;
  var m = 60;
  var ear = 45;

  if (B - ear >= 0) {
    console.log(`${A} ${B - ear}`);
  }
  else {
    A = A - 1
    if (A < 0) {
      A = 23;
      console.log(`${A} ${m + (B - ear)}`);
    } else {
      console.log(`${A} ${m + (B - ear)}`);
    }
  }
}

