dlist = input().split('-')
num = []
for i in dlist:
    temp = 0
    dl = i.split('+')
    for j in dl:
        temp += int(j)
    num.append(temp)
n = num[0]
for i in range(1, len(num)):
    n -= num[i]

print(n)