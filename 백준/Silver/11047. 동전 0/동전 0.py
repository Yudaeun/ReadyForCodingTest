n,k=map(int,input().split())
coin=[]

for _ in range(n):
    coin.append(int(input()))

answer=0
coin.sort()
for i in range(n-1,-1,-1):
    # print(k%coin[i])
    if k//coin[i]>0 :
        answer+=k//coin[i]
        k%=coin[i]


print(answer)