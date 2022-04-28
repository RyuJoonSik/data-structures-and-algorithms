/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
  const graph = prerequisites.reduce((table, [to, from]) => {
    table[to] === undefined ? (table[to] = [from]) : table[to].push(from);

    return table;
  }, {});
  const traced = new Set();
  const visited = new Set();

  const dfs = (i) => {
    if (traced.has(i)) {
      return false;
    }

    if (visited.has(i)) {
      return true;
    }

    traced.add(i);

    if (graph[i] !== undefined) {
      for (let node of graph[i]) {
        if (dfs(node) === false) {
          return false;
        }
      }
    }
    traced.delete(i);
    visited.add(i);

    return true;
  };

  for (let ss of Object.keys(graph)) {
    if (dfs(ss) === false) {
      return false;
    }
  }

  return true;
};
