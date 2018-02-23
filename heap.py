class Heap(object):
    MAX = 1
    MIN = 0
    heap_type = MAX

    def __init__(self):
        self.arr = []

    def insert(self, z):
        self.arr.append(z)
