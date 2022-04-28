/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  const used = {};
  let maxLength = 0,
    start = 0;

  for (let [index, char] of [...s].entries()) {
    if (char in used && start <= used[char]) {
      start = used[char] + 1;
    } else {
      maxLength = Math.max(maxLength, index - start + 1);
    }

    used[char] = index;
  }

  return maxLength;
};
