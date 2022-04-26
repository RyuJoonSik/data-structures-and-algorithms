/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function (height) {
  if (height.length === 0) {
    return 0;
  }

  let volume = 0;
  let [left, right] = [0, height.length - 1];
  let [left_max, right_max] = [height[left], height[right]];

  while (left < right) {
    [left_max, right_max] = [
      Math.max(height[left], left_max),
      Math.max(height[right], right_max),
    ];

    if (left_max <= right_max) {
      volume += left_max - height[left];
      left += 1;
    } else {
      volume += right_max - height[right];
      right -= 1;
    }
  }

  return volume;
};
