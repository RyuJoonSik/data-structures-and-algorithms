/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
  const result = [];

  const dfs = (currentSum, index, path) => {
    if (currentSum < 0) {
      return;
    }

    if (currentSum === 0) {
      result.push(path);
      return;
    }

    for (let i = index; i < candidates.length; i += 1) {
      dfs(currentSum - candidates[i], i, [...path, candidates[i]]);
    }
  };

  dfs(target, 0, []);

  return result;
};
