"""
임의의수 N, K가 있다.
N이 K의 값으로 나누어 떨어지면 K로 나누고
나누어지지 않을 때는 N-1을 한다.
최소 몇번의 반복 끝에 N이 1이 될 수 있는가?
"""

n, k = map(int, input().split())

result = 0

while n>=k:
    while n%k !=0:
        n-=1
        result+=1
    n//=k
    result+=1

while n>1:
    n-=1
    result+=1

print(result)