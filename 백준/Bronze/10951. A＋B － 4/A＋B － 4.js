const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().split('\n');

let cnt = 0;
while (cnt < input.length - 1) {
  let sp = input[cnt].split(' ');
  a = +sp[0];
  b = +sp[1];

  console.log(a + b);
  cnt++;


}