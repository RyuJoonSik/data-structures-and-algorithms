/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function (temperatures) {
  const answer = Array(temperatures.length).fill(0);
  const stack = [];

  for ([i, cur] of temperatures.entries()) {
    while (stack.length > 0 && cur > temperatures[stack[stack.length - 1]]) {
      const last = stack.pop();
      answer[last] = i - last;
    }

    stack.push(i);
  }

  return answer;
};
