#int(ord('a')) --> a의 아스키 코드를 사용할 수 있음 --> 그러면 이동을 수리적으로 할 수 있다. 
x = int(input())
y = int(ord(input()))
 
#가능한 움직임
steps = [(-2, -1), (-2, 1), (2, -1), (2, -1), (-1, 2), (-1, -2), (1, 2), (1, -2)]

result = 0

for step in steps:
    nx = x + step[0]
    ny = y + step[1]
    if nx <= 1 or nx >= 8 or chr(ny) <= 'a' or chr(ny) >= 'h':
        continue
    result += 1

print(result)