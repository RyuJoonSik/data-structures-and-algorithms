/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const numsTable = {};

  for (let i = 0; i < nums.length; i += 1) {
    if (Object.hasOwnProperty.call(numsTable, target - nums[i])) {
      return [i, numsTable[target - nums[i]]];
    }

    numsTable[nums[i]] = i;
  }
};
