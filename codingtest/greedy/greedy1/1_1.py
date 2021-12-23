from sys import stdin

n = int(input())

group = list(map(int, input().split()))
group.sort() # 오름차순 정렬

result = 0
count = 0
for i in group:
    count+=1
    if count >= i:
        count=0
        result+=1
    
print(result)