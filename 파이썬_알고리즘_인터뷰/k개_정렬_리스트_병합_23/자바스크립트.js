/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
  let root, result;
  root = result = new ListNode();
  const q = [];

  for (let i = 0; i < lists.length; i += 1) {
    if (lists[i] !== null) {
      q.push(lists[i]);
    }
  }

  q.sort((a, b) => a.val - b.val);

  while (q.length > 0) {
    result.next = q.shift();
    result = result.next;

    if (result.next !== null) {
      q.push(result.next);
      q.sort((a, b) => a.val - b.val);
    }
  }

  return root.next;
};
