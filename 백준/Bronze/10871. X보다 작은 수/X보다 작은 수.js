const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

let input1 = input[0].split(' ');
let input2 = input[1].split(' ');
var a = '';
for (let i = 0; i < input1[0]; i++) {
  if (+input2[i] < +input1[1]) {
    a += input2[i] + ' ';
  }
}
console.log(a);

