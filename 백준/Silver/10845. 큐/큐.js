var fs = require("fs");
var input = fs.readFileSync("/dev/stdin").toString().split("\n");
let length = parseInt(input[0], 10);

let queue = [];
let frontIndex = 0;
let output = [];

for (let i = 1; i <= length; i++) {
  let row = input[i].split(" ");
  let command = row[0];

  if (command === "push") {
    queue.push(row[1]);
  } else if (command === "pop") {
    if (queue.length === frontIndex) {
      output.push("-1");
    } else {
      output.push(queue[frontIndex]);
      frontIndex++;
    }
  } else if (command === "size") {
    output.push(queue.length - frontIndex);
  } else if (command === "empty") {
    output.push(queue.length === frontIndex ? "1" : "0");
  } else if (command === "front") {
    if (queue.length === frontIndex) {
      output.push("-1");
    } else {
      output.push(queue[frontIndex]);
    }
  } else if (command === "back") {
    if (queue.length === frontIndex) {
      output.push("-1");
    } else {
      output.push(queue[queue.length - 1]);
    }
  }
}

console.log(output.join("\n"));
