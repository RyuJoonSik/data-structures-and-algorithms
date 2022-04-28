/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function (n, k) {
  const results = [];

  const dfs = (elements, start, count) => {
    if (count === 0) {
      results.push([...elements]);
    }

    for (let i = start; i <= n; i += 1) {
      elements.push(i);
      dfs(elements, i + 1, count - 1);
      elements.pop();
    }
  };

  dfs([], 1, k);

  return results;
};
