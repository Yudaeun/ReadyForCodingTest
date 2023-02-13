r,c,q=map(int,input().split())
bright=[]
for _ in range(r):
    bright.append(list(map(int,input().split())))
dp=[[0]*(c+1) for _ in range(r)]
for i in range(r):
    for j in range(1,c+1):
        dp[i][j]+=dp[i][j-1]+bright[i][j-1]
for _ in range(q):
    x1,y1,x2,y2=map(int,input().split())

    # print(dp)
    answer=0
    for i in range(x1-1,x2):
        answer+=dp[i][y2]-dp[i][y1-1]
        # print(answer)
    print(answer//((x2-x1+1)*(y2-y1+1)))