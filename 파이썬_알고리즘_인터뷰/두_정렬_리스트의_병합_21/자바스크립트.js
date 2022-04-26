/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function (list1, list2) {
  if (list1 === null || (list2 !== null && list1.val > list2.val)) {
    [list1, list2] = [list2, list1];
  }

  if (list1 !== null) {
    list1.next = mergeTwoLists(list1.next, list2);
  }

  return list1;
};
