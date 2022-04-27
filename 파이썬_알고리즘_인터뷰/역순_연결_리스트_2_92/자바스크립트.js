/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function (head, left, right) {
  if (head === null || left === right) {
    return head;
  }

  let root, start;
  root = start = new ListNode();
  root.next = head;

  for (let i = 0; i < left - 1; i += 1) {
    start = start.next;
  }

  let end = start.next;

  for (let i = 0; i < right - left; i += 1) {
    let temp = start.next;
    [start.next, end.next] = [end.next, end.next.next];
    start.next.next = temp;
  }

  return root.next;
};
