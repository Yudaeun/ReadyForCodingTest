t=int(input())

for _ in range(t):
    n=int(input())
    dp=[1]*n
    for i in range(3,n):
        dp[i]=dp[i-3]+dp[i-2]
    print(dp[n-1])