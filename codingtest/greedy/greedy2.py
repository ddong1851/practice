"""
행열 NxM 의 카드들 중
뽑고 싶은 카드의 행을 선택한 후
해당 행의 가장 낮은 수의 카드를 뽑는다
다음 카드에서 가장 큰 수의 카드를 뽑도록 전략을 세운다.

--> 행들이 갖는 가장 낮은 숫자 중 가장 큰 수를 뽑는다.

1<=N, M<=100


n, m = map(int, input().split())
result = 0

for i in range (n):
    data = list(map(int, input().split()))          #행의 데이터를 입력받는다.
    min_value=min(data)                             #해당 행의 데이터들 중 가장 낮은 값을 min()함수를 통해 입력받는다
    result = max(result, min_value)                 #저장된 result와 min_value 중 더 큰 값을 result로 갱신

print(result)
"""

n, m = map(int, input().split())
result = 0

for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    result = max(result, min_value)

print(result)