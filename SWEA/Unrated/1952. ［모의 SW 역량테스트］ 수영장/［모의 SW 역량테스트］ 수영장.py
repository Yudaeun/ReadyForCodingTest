t=int(input())

for test in range(1,t+1):
    fee=list(map(int,input().split()))
    month=list(map(int,input().split()))
    dp=[0]*15
    dp[0]=min(fee[0]*month[0],fee[1])
    flag=0
    for i in range(1,12):
        dp[i]=min(fee[0]*month[i],fee[1])+dp[i-1]
        if i>=2 and dp[i-2] and dp[i]>fee[2]+dp[i-3]:
            dp[i]=fee[2]+dp[i-3]
            if i==10: flag=1
    if flag==1:
        dp[11]=min(dp[11],dp[i-1]+fee[2])
    dp[11]=min(dp[11],fee[3])
    print(f'#{test} {dp[11]}')
