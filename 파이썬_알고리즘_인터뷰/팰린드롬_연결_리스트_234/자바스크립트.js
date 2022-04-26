/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function (head) {
  const list = [];
  let node = head;

  while (node !== null) {
    list.push(node.val);
    node = node.next;
  }

  while (list.length > 1) {
    if (list.shift() != list.pop()) {
      return false;
    }
  }

  return true;
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
 * @return {boolean}
 */
var isPalindrome = function (head) {
  console.log(head);
  let rev = null;
  let [slow, fast] = [head, head];

  while (fast && fast.next) {
    fast = fast.next.next;

    const prev_rev = rev;
    rev = slow;
    slow = slow.next;
    rev.next = prev_rev;
  }

  if (fast) {
    slow = slow.next;
  }

  while (rev !== null && rev.val === slow.val) {
    slow = slow.next;
    rev = rev.next;
  }

  return rev === null;
};
