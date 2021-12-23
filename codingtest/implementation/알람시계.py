h, m = map(int, input().split())

def alarm(h, m):
    m -= 45
    if m < 0:
        m = 60 + m
        h -= 1
        if h<0:
            h = 23
    print(f"{h} {m}")

alarm(h, m)