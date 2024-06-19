import sys
input=sys.stdin.readline

n=int(input())
a=[0]+list(map(int,input().split()))
m=int(input())
dp=[0]*(n+1)
dp[1]=a[1]

for i in range(2,n+1):
    dp[i]=dp[i-1]+a[i]

for _ in range(m):
    start,end=map(int,input().split())
    print(dp[end]-dp[start-1])