t=int(input())
for _ in range(t):
    n=int(input())
    binary=0
    mod=n
    for i in range(n):
        binary=mod%2
        mod=mod//2
        if binary==1:
            print(i,end=' ')