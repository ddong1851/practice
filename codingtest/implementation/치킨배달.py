n, m = map(int, input().split())
dlist = [list(map(int, input().split())) for _ in range(n)]
list1 = [(i, j) for i in range(n) for j in range(n) if dlist[i][j]==1] #집들의 좌표
list2 = [(i, j) for i in range(n) for j in range(n) if dlist[i][j]==2] #치킨집의 좌표
num = []
print(list2)
print(list1)
print(min(list1))
result = 0
for x1, y1 in list1:
    temp = 0
    for x2, y2 in list2:
        temp += (abs(x1-x2) + abs(y1-y1))
    num.append(temp)

print(num)
print(result)
