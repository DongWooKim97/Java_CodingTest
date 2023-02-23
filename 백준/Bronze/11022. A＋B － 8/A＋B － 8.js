const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

let testCase = +input[0];

for (let i = 1; i <= testCase; i++) {
  let s = input[i].split(' ');

  console.log(`Case #${i}: ${+s[0]} + ${+s[1]} = ${+s[0] + +s[1]}`);
}