/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function (nums) {
  return nums
    .sort((a, b) => a - b)
    .filter((_, index) => index % 2 == 0)
    .reduce((acc, value) => acc + value);
};
