"""
def combi(n, m):
    return f(n) / f(m) * f(n-m)

조합의 수 (n 개의 서로 다른 원소에서 m 개를 택하는 경우의 수) 구하기
def combi(n, m):
    if n==m: return 1
    elif m==0: return 1
    else: return combi(n-1, m) + combi(n-1, m-1)

이 방식은 반복문에 비해효율은 떨어지나 
사람의 생각을 구현할 수 있는 장점이 있다. 

피보나치 수열
def fibo(n):
    if n<=1:
        return n
    return fibo(n-1) + fibo(n-2)

def iter(n):
    if n<=1:
        return n
    else:
        i=2
        t0=0
        t1=1
        while i<=n:
            t0, t1 = t1, t0+t1
            i+=1
        return t1

def binsearch(L, x, lower, upper):
    if upper<lower:
        return -1
    mid = (lower + upper) // 2
    if x==L[mid]:
        return mid
    elif x < L[mid]:
        return binsearch(L, x, lower, mid-1)
    else:
        return binsearch(L, x, mid+1, upper-1)
"""