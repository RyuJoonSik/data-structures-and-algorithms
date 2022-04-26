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
var swapPairs = function (head) {
  let cur = head;

  while (cur !== null && cur.next !== null) {
    [cur.val, cur.next.val] = [cur.next.val, cur.val];
    cur = cur.next.next;
  }

  return head;
};

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
var swapPairs = function (head) {
  let root, prev;
  root = prev = new ListNode();
  root.next = head;

  while (head !== null && head.next !== null) {
    let b = head.next;
    head.next = b.next;
    b.next = head;

    prev.next = b;

    head = head.next;
    prev = prev.next.next;
  }

  return root.next;
};

var swapPairs = function (head) {
  if (head !== null && head.next !== null) {
    let p = head.next;
    head.next = swapPairs(p.next);
    p.next = head;

    return p;
  }

  return head;
};
