/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
  const results = [];
  nums.sort((a, b) => a - b);

  for (let i = 0; i < nums.length - 2; i += 1) {
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    }

    let [left, right] = [i + 1, nums.length - 1];

    while (left < right) {
      const sum = nums[i] + nums[left] + nums[right];

      if (sum < 0) {
        left += 1;
      } else if (sum > 0) {
        right -= 1;
      } else {
        results.push([nums[i], nums[left], nums[right]]);

        while (left < right && nums[left] === nums[left + 1]) {
          left += 1;
        }

        while (left < right && nums[right] === nums[right - 1]) {
          right -= 1;
        }

        left += 1;
        right -= 1;
      }
    }
  }

  return results;
};
