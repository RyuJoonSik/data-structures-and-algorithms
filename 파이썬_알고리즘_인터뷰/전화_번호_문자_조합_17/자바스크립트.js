/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  const result = [];
  const dic = {
    2: "abc",
    3: "def",
    4: "ghi",
    5: "jkl",
    6: "mno",
    7: "pqrs",
    8: "tuv",
    9: "wxyz",
  };

  const dfs = (index, path) => {
    if (path.length === digits.length) {
      result.push(path);
      return;
    }

    for (let i = index; i < digits.length; i += 1) {
      for (let char of dic[digits[i]]) {
        dfs(i + 1, path + char);
      }
    }
  };

  if (digits.length === 0) {
    return [];
  }

  dfs(0, "");

  return result;
};
