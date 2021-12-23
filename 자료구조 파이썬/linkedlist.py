# 홈버튼 2번으로 가는 앱 화면 띄울 때 사용하면 좋음
"""
장점 : 
삽입 삭제가 유연하다

단점 :
 
"""

class Node:

    def __init__(self, item):
        self.data = item
        self.next = None


class LinkedList:

    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None

    # print 할때 출력하는 설명문
    def __repr__(self):
        if self.nodeCount == 0:
            return 'LinkedList: empty'

        s = ''
        curr = self.head
        while curr is not None:
            s += repr(curr.data)
            if curr.next is not None:
                s += ' -> '
            curr = curr.next
        return s


    def getAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
            return None

        i = 1
        curr = self.head
        while i < pos:
            curr = curr.next
            i += 1

        return curr


    def insertAt(self, pos, newNode):
        if pos < 1 or pos > self.nodeCount + 1:
            return False

        if pos == 1:
            newNode.next = self.head
            self.head = newNode

        else:
            if pos == self.nodeCount + 1:
                prev = self.tail
            else:
                prev = self.getAt(pos - 1)
            newNode.next = prev.next
            prev.next = newNode

        if pos == self.nodeCount + 1:
            self.tail = newNode

        self.nodeCount += 1
        return True


    def getLength(self):
        return self.nodeCount


    def traverse(self):
        result = []
        curr = self.head
        while curr is not None:
            result.append(curr.data)
            curr = curr.next
        return result


    def concat(self, L):
        self.tail.next = L.head
        if L.tail:
            self.tail = L.tail
        self.nodeCount += L.nodeCount

    def popAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
            raise IndexError

        curr = self.getAt(pos)
        if pos == 1:                    #head일 때
            if pos == self.nodeCount:   #유일한 노드
                self.head = None
                self.tail = None
            else:                       #그냥 첫번째 요소일 때
                self.head = curr.next  
            self.nodeCount-=1

        else:
            if pos == self.nodeCount:   #tail일 때
                prev = self.getAt(pos-1)
                prev.next = None
                self.tail = prev
            else:                       #중간에 낀 노드
                prev = self.getAt(pos-1)
                following = curr.next
                prev.next = following
            self.nodeCount-=1

        return curr.data


