/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  const wordList = strs.reduce((list, word) => {
    const keyWord = word.split("").sort().join("");
    list[keyWord] = list[keyWord] || [];
    list[keyWord].push(word);

    return list;
  }, {});

  return Object.values(wordList);
};
