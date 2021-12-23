"""
연결 리스트

기본적인 연결 리스트

노드
data + link(next)

노드 내의 데이터는 자유롭게 !

리스트의 시작은 head
마지막은 tail

노드의 생성
class Node:
    def __init__(self, item):
        self.data = item
        self.next = None 

비어있는 연결 리스트 구조 생성
class LinkedList:
    def __init__(self):
        self.nodeCount = 0
        self.head = None
        self.tail = None

    특정 원소 참조
    def getAt(self, pos):
        if pos <=0 or pos>self.nodeCount:
            return None
        i = 1
        current = self.head
        while i<pos:
            current = currentif.next
            i+=1
        return current

    def traverse(self):
        answer = []
        curr = self.head        # 현재 노드
        if curr==None:
            return answer
        while True:             # 다음 노드가 없을 때까지 반복
            answer.append(curr.data)
            curr = curr.next
            if curr==None:      # 다음 노드가 없으면 반복문 탈출
                break
        return answer

배열        vs      연결 리스트
연속힌 위치         임의의 위치
간편한 지칭         선형탐색과 유사
O(1)                O(n)


    def popAfter(self, prev):
        if prev.next == None:
            return None
        
        curr = prev.next
        
        if curr.next == None:
            if self.nodeCount == 1:
                self.tail = None   
                self.head.next = self.tail
            else :
                prev.next = None
                self.tail = prev
        else:
            prev.next = curr.next
            
        self.nodeCount -= 1
        return curr.data
        
    def popAt(self, pos):
        if pos < 1 or pos > self.nodeCount:
            raise IndexError
        
        return self.popAfter(self.getAt(pos-1)) 
        
"""