from linkedlist import * \

a = Node(79)
b = Node(45)
c = Node(42)
L = LinkedList()

print(L)

L.insertAt(1, a)
L.insertAt(2, b)
L.insertAt(3, c)

print(L)
print(L.getLength())