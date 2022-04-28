/**
 * @param {string[][]} tickets
 * @return {string[]}
 */
var findItinerary = function (tickets) {
  const graph = {};
  tickets.sort();
  for (let [from, to] of tickets) {
    graph[from] === undefined ? (graph[from] = [to]) : graph[from].push(to);
  }

  let route = [];
  let stack = ["JFK"];

  while (stack.length > 0) {
    while (
      graph[stack[stack.length - 1]] &&
      graph[stack[stack.length - 1]].length > 0
    ) {
      stack.push(graph[stack[stack.length - 1]].shift());
    }
    route.push(stack.pop());
  }

  return route.reverse();
};
