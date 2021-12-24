n, m = map(int, input().split())
# n 은 세로 m이 가로

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

count = 0

def dfs(x, y):
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1 # 방문 처리
        #상하좌우 탐색
        dfs(x, y-1)
        dfs(x, y+1)
        dfs(x-1, y)
        dfs(x+1, y)
        return True
    return False

for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            count += 1

print(count)