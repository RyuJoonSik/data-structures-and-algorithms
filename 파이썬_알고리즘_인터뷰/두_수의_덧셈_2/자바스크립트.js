/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  const reverseList = (head) => {
    let [node, prev, next] = [head, null];

    while (node !== null) {
      [next, node.next] = [node.next, prev];
      [prev, node] = [node, next];
    }

    return prev;
  };

  const toList = (node) => {
    const list = [];

    while (node !== null) {
      list.push(node.val);
      node = node.next;
    }

    return list;
  };

  const toReversedLinkedList = (result) => {
    let prev = null;

    for (let char of result) {
      let node = new ListNode(char);
      node.next = prev;
      prev = node;
    }

    return prev;
  };

  let a = toList(reverseList(l1));
  let b = toList(reverseList(l2));
  let resultStr =
    BigInt(a.reduce((str, val) => str + val, "")) +
    BigInt(b.reduce((str, val) => str + val, ""));

  return toReversedLinkedList(String(resultStr));
};

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let root, head;
  root = head = new ListNode(0);
  let [sum, carry] = [0, 0];

  while (l1 !== null || l2 !== null || carry !== 0) {
    sum = 0;

    if (l1 !== null) {
      sum += l1.val;
      l1 = l1.next;
    }

    if (l2 !== null) {
      sum += l2.val;
      l2 = l2.next;
    }

    let val;

    [carry, val] = [Math.floor((sum + carry) / 10), (sum + carry) % 10];
    head.next = new ListNode(val);
    head = head.next;
  }

  return root.next;
};
