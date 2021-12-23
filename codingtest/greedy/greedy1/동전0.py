n, k = map(int, input().split())
coin_types = []
result = 0
for i in range(n):
    coin_types.append(int(input()))

for i in range(n-1, -1, -1):
    if k==0:
        break
    if(k/coin_types[i]<1):
        continue
    else:
        result+=(k//coin_types[i])
        k %= coin_types[i]

print(result)
