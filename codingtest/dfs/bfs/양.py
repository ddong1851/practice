from collections import deque

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(str, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solution(x, y):
    global sheep, wolve
    dv, do = 0, 0
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
        

for i in range(n):
    for j in range(m):
        solution(i, j)