/**
 * @param {string} jewels
 * @param {string} stones
 * @return {number}
 */
var numJewelsInStones = function (jewels, stones) {
  return [...stones]
    .map((stone) => jewels.includes(stone))
    .reduce((acc, val) => acc + val, 0);
};
