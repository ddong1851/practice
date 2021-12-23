n = int(input())                      # n시 입력

result = 0

#(hr)-(min)-(sec) 구조에 3이 포함된다면 result += 1을 해라
for hr in range(n+1):
    for min in range(60):
        for sec in range(60):
            if '3' in str(hr) + str(min) + str(sec):
                result += 1

print(result)

