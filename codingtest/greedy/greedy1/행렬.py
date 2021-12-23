n, m = map(int, input().split())
#list 만들 때 사용할 수 있는 방법, append보다는 조금 간지 
A = [list(map(int, input())) for _ in range(n)]
B = [list(map(int, input())) for _ in range(n)]

def convert(x, y):
    for i in range(x, x+3):
        for j in range(y, y+3):
            A[x][y]
    return True
