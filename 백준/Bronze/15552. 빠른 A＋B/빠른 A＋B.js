let input = require('fs').readFileSync('dev/stdin').toString().split('\n');
let answer = '';
for (let i = 1; i <= +input[0]; i++) {
  let s = input[i].split(' ');
  answer += (+s[0] + +s[1] + "\n");
}
console.log(answer);
