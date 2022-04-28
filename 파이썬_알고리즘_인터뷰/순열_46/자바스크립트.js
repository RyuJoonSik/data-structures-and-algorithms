/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function (nums) {
  const results = [];
  const prev_elements = [];

  const dfs = (elements) => {
    if (elements.length === 0) {
      results.push([...prev_elements]);
    }

    for (let e of elements) {
      const next_elements = [...elements];
      next_elements.splice(next_elements.indexOf(e), 1);

      prev_elements.push(e);
      dfs(next_elements);
      prev_elements.pop();
    }
  };

  dfs(nums);

  return results;
};
