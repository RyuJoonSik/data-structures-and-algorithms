class MyCircularQueue:

    def __init__(self, k: int):
        self.q = [None] * k
        self.maxlen = k
        self.frontPointer = 0
        self.rearPointer = 0

    def enQueue(self, value: int) -> bool:
        if self.q[self.rearPointer] is None:
            self.q[self.rearPointer] = value
            self.rearPointer = (self.rearPointer + 1) % self.maxlen
            return True
        else:
            return False

    def deQueue(self) -> bool:
        if self.q[self.frontPointer] is None:
            return False
        else:
            self.q[self.frontPointer] = None
            self.frontPointer = (self.frontPointer + 1) % self.maxlen
            return True

    def Front(self) -> int:
        return -1 if self.q[self.frontPointer] is None else self.q[self.frontPointer]

    def Rear(self) -> int:
        return -1 if self.q[self.rearPointer - 1] is None else self.q[self.rearPointer - 1]

    def isEmpty(self) -> bool:
        return self.frontPointer == self.rearPointer and self.q[self.frontPointer] is None

    def isFull(self) -> bool:
        return self.frontPointer == self.rearPointer and self.q[self.frontPointer] is not None


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()