"""
큰 수의 법칙 문제
N개의 숫자 배열 중 
총 M번 반복하여 가장 큰 수를 만드는 방법
단 한 원소를 K번까지 반복할 수 있다
"""

n, m, k = map(int, input().split())
#n개의 수 입력, m번 반복, k번 최대 원소 반복 가능

#데이터라는 리스트에 그리디에 사용할 문자 입력
#꼭 sort()와 list 생성 부를 2줄로 호출하자
data = list(map(int, input().split()))
data.sort()

first = data[n-1]
second = data[n-2]

result = 0

while True:
    for i in range(k):
        if m==0:            # 반복 횟수 다 채우면 탈출
            break
        result += first     # k번 돌면서 결과값에 가장 큰 수를 더한다
        m-=1
    if m==0:                # 반복 횟수 다 채우면 탈출
        break
    result+=second          # k번의 반복 후 m==0이 아니라면 두번째로 가장 큰 수를 더하고 다시 반복
    m-=1

print(result)
