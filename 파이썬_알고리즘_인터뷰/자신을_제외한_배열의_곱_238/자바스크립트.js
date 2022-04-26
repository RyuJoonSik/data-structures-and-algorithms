/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function (nums) {
  const out = [];
  let p = 1;

  for (let i = 0; i < nums.length; i += 1) {
    out.push(p);
    p *= nums[i];
  }

  p = 1;

  for (let i = nums.length - 1; i > -1; i -= 1) {
    out[i] *= p;
    p *= nums[i];
  }

  return out;
};
