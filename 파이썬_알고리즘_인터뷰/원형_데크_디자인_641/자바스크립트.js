/**
 * @param {number} k
 */
var MyCircularDeque = function (k) {
  this.head = new ListNode();
  this.tail = new ListNode();
  this.maxSize = k;
  this.size = 0;
  this.head.right = this.tail;
  this.tail.left = this.head;
};

/**
 * @param {number} value
 * @return {boolean}
 */

MyCircularDeque.prototype.add = function (node, newNode) {
  let prevRightNode = node.right;
  node.right = newNode;
  [newNode.left, newNode.right] = [node, prevRightNode];
  prevRightNode.left = newNode;
};

MyCircularDeque.prototype.del = function (node) {
  const prevRightRightNode = node.right.right;
  node.right = prevRightRightNode;
  prevRightRightNode.left = node;
};

MyCircularDeque.prototype.insertFront = function (value) {
  if (this.size === this.maxSize) {
    return false;
  }

  this.size += 1;
  this.add(this.head, new ListNode(value));

  return true;
};

/**
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function (value) {
  if (this.size === this.maxSize) {
    return false;
  }

  this.size += 1;
  this.add(this.tail.left, new ListNode(value));

  return true;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function () {
  if (this.size === 0) {
    return false;
  }

  this.size -= 1;
  this.del(this.head);

  return true;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function () {
  if (this.size === 0) {
    return false;
  }

  this.size -= 1;
  this.del(this.tail.left.left);

  return true;
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function () {
  return this.size > 0 ? this.head.right.val : -1;
};

/**
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function () {
  return this.size > 0 ? this.tail.left.val : -1;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function () {
  return this.size === 0;
};

/**
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function () {
  return this.size === this.maxSize;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
