/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  const expand = (left, right) => {
    while (left >= 0 && right <= s.length && s[left] == s[right - 1]) {
      left -= 1;
      right += 1;
    }

    return s.slice(left + 1, right - 1);
  };

  if (s.length < 2 || s == s.split("").reverse().join("")) {
    return s;
  }

  result = "";

  for (let i = 0; i < s.length - 1; i += 1) {
    const evenInterval = expand(i, i + 1);
    const oddInterval = expand(i, i + 2);

    if (evenInterval.length > result.length) {
      result = evenInterval;
    }

    if (oddInterval.length > result.length) {
      result = oddInterval;
    }
  }

  return result;
};
