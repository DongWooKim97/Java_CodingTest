let input = require('fs').readFileSync('dev/stdin').toString().split('\n');

input = +input[0];
var sum = 0
for (let i = 1; i <= input; i++) {
  sum += i;
}
console.log(sum);


