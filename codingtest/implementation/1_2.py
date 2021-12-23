n, m = map(int, input().split())
x, y, d = map(int, input().split())
#북 동 남 서 기준
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, 1]
field = [list(map(int, input().split())) for _ in range(m)]
count = 0

def clean(x, y, d):
    return True

clean(x, y, d)