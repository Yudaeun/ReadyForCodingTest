n,k=map(int,input().split())
num=[]
for i in range(n):
    num.append(list(map(int,input().split())))

dp=[[0]*(k+1) for _ in range(n+1)]

for i in range(n):
    w=num[i][0]
    v=num[i][1]
    for j in range(1,k+1):
        if j<w:
            dp[i][j]=dp[i-1][j]
        else:
            dp[i][j]=max(dp[i-1][j],dp[i-1][j-w]+v)
print(dp[n-1][k])