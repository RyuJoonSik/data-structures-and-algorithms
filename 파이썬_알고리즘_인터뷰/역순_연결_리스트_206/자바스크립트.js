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
var reverseList = function (head) {
  const reverse = (node, nodePrev = null) => {
    if (node === null) {
      return nodePrev;
    }

    let next;
    [next, node.next] = [node.next, nodePrev];

    return reverse(next, node);
  };

  return reverse(head);
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
var reverseList = function (head) {
  let [node, nodePrev, next] = [head, null];

  while (node !== null) {
    [next, node.next] = [node.next, nodePrev];
    [nodePrev, node] = [node, next];
  }

  return nodePrev;
};
