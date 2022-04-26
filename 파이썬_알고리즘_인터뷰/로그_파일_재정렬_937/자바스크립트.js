/**
 * @param {string[]} logs
 * @return {string[]}
 */
var reorderLogFiles = function (logs) {
  const [letters, digits] = [[], []];

  for (const log of logs) {
    if (isNaN(log.split(" ")[1])) {
      letters.push(log);
    } else {
      digits.push(log);
    }
  }

  letters.sort((a, b) => {
    const contentA = a.slice(a.indexOf(" ") + 1);
    const contentB = b.slice(b.indexOf(" ") + 1);

    if (contentA === contentB) {
      return a.slice(0, a.indexOf(" ")) > b.slice(0, b.indexOf(" ")) ? 1 : -1;
    } else {
      return contentA > contentB ? 1 : -1;
    }
  });

  return [...letters, ...digits];
};
