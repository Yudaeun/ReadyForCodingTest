t=int(input())

for test in range(t):
    n,m=map(int,input().split())
    bigNum=max(n,m)
    smallNum=min(n,m)
    sumN,sumM,sumNM=1,1,1
    # bigNumCsmallNum
    # nCr= n!/(n-r)!r!
    for i in range(1,bigNum+1):
        sumN*=i
    for i in range(1,smallNum+1):
        sumM*=i
    for i in range(1,bigNum-smallNum+1):
        sumNM*=i
    answer=sumN//(sumNM*sumM)
    print(answer)