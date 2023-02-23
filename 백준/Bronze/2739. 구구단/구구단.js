const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

input = +input[0];
solution(input);
function solution(s) {
  for (let i = 1; i <= 9; i++) {
    console.log(`${s} * ${i} = ${s * i}`);
  }


}
