/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function (nums, k) {
  const numsTable = nums.reduce((table, num) => {
    table[num] = table[num] === undefined ? 1 : table[num] + 1;

    return table;
  }, {});

  return Object.entries(numsTable)
    .sort((a, b) => b[1] - a[1])
    .slice(0, k)
    .map((arr) => arr[0]);
};
