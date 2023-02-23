const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

input = input[0];
input = input.split(' ').map((item) => +item);
// input = input.map((item) => +item);
// solution(input[0], input[1]);
solution(input[0]);

function solution(A) {
  if (A % 4 === 0) {
    if (A % 100 !== 0 || A % 400 === 0) {
      console.log(1);
    }
    else {
      console.log(0);
    }
  }
  else {
    console.log(0);
  }
}