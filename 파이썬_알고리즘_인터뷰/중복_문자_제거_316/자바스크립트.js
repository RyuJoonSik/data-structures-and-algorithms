/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function (s) {
  const isDuplicatedSet = (set1, set2) => {
    for (let value of set1) {
      if (!set2.has(value)) {
        return false;
      }
    }

    return set1.size === set2.size;
  };

  let stringSet = new Set(s);

  for (let char of [...stringSet].sort()) {
    let suffix = s.slice(s.indexOf(char));
    let suffixSet = new Set(suffix);

    if (isDuplicatedSet(stringSet, suffixSet)) {
      const reg = new RegExp(`${char}`, "g");

      return char + removeDuplicateLetters(suffix.replace(reg, ""));
    }
  }

  return "";
};

/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function (s) {
  let counter = [...s].reduce((table, char) => {
    table[char] = table[char] !== undefined ? table[char] + 1 : 1;

    return table;
  }, {});

  let [seen, stack] = [new Set(), []];

  for (let char of s) {
    counter[char] -= 1;
    if (seen.has(char)) {
      continue;
    }

    while (
      stack.length > 0 &&
      char < stack[stack.length - 1] &&
      counter[stack[stack.length - 1]] > 0
    ) {
      seen.delete(stack.pop());
    }

    stack.push(char);
    seen.add(char);
  }

  return stack.join("");
};
