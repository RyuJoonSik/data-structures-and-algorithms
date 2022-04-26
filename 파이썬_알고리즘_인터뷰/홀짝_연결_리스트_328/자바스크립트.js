/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function (head) {
  if (head === null) {
    return null;
  }

  let [odd, even, even_head] = [head, head.next, head.next];

  while (even !== null && even.next !== null) {
    [odd.next, even.next] = [odd.next.next, even.next.next];
    [odd, even] = [odd.next, even.next];
  }

  odd.next = even_head;

  return head;
};
