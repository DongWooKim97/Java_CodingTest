const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

input = input[0];
// input = input.split(' ').map((item) => +item);

// solution(input[0], input[1]);
solution(input);

function solution(s) {
  var nir = +s - 543;
  console.log(nir);
}
