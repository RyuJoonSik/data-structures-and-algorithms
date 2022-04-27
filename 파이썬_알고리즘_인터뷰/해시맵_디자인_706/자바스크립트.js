class ListNode {
  constructor(key = null, value = null) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

var MyHashMap = function () {
  this.size = 1000;
  this.table = {};

  for (let i = 0; i < this.size; i += 1) {
    this.table[i] = new ListNode();
  }
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
  let index = key % this.size;

  if (this.table[index].value == null) {
    this.table[index] = new ListNode(key, value);
    console.log(this.table[index].value);
    return;
  }

  let p = this.table[index];

  while (p != null) {
    if (p.key === key) {
      p.value = value;
      return;
    }

    if (!p.next) {
      break;
    }

    p = p.next;
  }

  p.next = new ListNode(key, value);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
  let index = key % this.size;

  if (this.table[index].value == null) {
    return -1;
  }

  let p = this.table[index];

  while (p != null) {
    if (p.key === key) {
      return p.value;
    }

    p = p.next;
    return -1;
  }
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
  let index = key % this.size;

  if (this.table[index].value == null) {
    return;
  }

  let p = this.table[index];

  if (p.key === key) {
    this.table[index] = p.next == null ? new ListNode() : p.next;

    return;
  }

  let prev = p;

  while (p != null) {
    if (p.key === key) {
      prev.next = p.next;
      return;
    }

    [prev, p] = [p, p.next];
  }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
