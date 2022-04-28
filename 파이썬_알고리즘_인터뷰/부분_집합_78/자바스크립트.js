/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  const result = [];

  const dfs = (index, path) => {
    result.push(path);

    for (let i = index; i < nums.length; i += 1) {
      dfs(i + 1, [...path, nums[i]]);
    }
  };

  dfs(0, []);

  return result;
};
