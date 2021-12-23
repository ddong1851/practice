"""
x, y = 1, 1                             #시작 좌표
n = map(int, input().split())           #n 입력 받기
move = input().split()                  #이동 방향 입력받기

move_types = {'L':-1, 'R':1, 'U':-1, 'D':1}
# 해당 풀이는 내 풀이인데, 반복문 내의 조건문이 너무 많다.
for dir in move:
    if dir == 'L':
        if x!=1:
            x += move_types.get(dir)
    elif dir == 'R':
        if x!=n:
            x += move_types.get(dir)
    elif dir == 'U':
        if y!=1:
            y += move_types.get(dir)
    elif dir == 'D':
        if y!=n:
            y += move_types.get(dir)

print(x, y)
"""

# 이 방식이 2줄 더 줄어들 뿐더러 조건문이 줄어든다
x, y = 1, 1
n = int(input())        
plans = input().split()

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

move_types = ['L', 'R', 'U', 'D']

for plan in plans:
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx<1 or ny<1 or nx>n or ny>n:
        continue
    x, y = nx, ny

print(x,y)