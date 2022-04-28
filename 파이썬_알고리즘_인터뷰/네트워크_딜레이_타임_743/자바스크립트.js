/**
 * @param {number[][]} times
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var networkDelayTime = function (times, n, k) {
  const graph = {};

  for (let [from, to, time] of times) {
    graph[from] === undefined
      ? (graph[from] = [[to, time]])
      : graph[from].push([to, time]);
  }

  const q = [[k, 0]];
  const dist = {};

  while (q.length > 0) {
    q.sort((a, b) => b[1] - a[1]);
    let [from, time] = q.pop();

    if (dist[from] === undefined) {
      dist[from] = time;

      if (graph[from] === undefined) {
        continue;
      }

      for (let [to, extraTime] of graph[from]) {
        const alt = time + extraTime;
        q.push([to, alt]);
      }
    }
  }

  if (Object.keys(dist).length === n) {
    return Math.max(...Object.values(dist));
  }

  return -1;
};
