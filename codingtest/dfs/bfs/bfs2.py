from typing import Collection


from collections import deque

#n, m을 입력받는다.
n, m = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

#그래프 생성
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

def bfs(x, y):
    #큐 생성
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y]+1
                queue.append((nx, ny))
    return graph[n-1][m-1]

print(bfs(0, 0))