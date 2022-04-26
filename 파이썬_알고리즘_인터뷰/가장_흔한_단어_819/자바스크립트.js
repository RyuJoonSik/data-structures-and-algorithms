/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function (paragraph, banned) {
  const banList = banned.reduce((list, word) => {
    list[word] = true;

    return list;
  }, {});

  paragraphs = paragraph.replace(/[^\w]/g, " ").split(" ");
  counter = {};

  for (let word of paragraphs) {
    if (banList[word.toLowerCase()] || !word) {
      continue;
    }

    if (!counter[word.toLowerCase()]) {
      counter[word.toLowerCase()] = 0;
    }

    counter[word.toLowerCase()] += 1;
  }

  let maxCount = -Infinity;
  let answer = "";

  for (let [word, count] of Object.entries(counter)) {
    if (count > maxCount) {
      maxCount = count;
      answer = word;
    }
  }

  return answer;
};
