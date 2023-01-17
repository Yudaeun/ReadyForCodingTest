n,k=map(int,input().split())
coin=[]
for _ in range(n):
    coin.append(int(input()))

m=[10001]*(k+1)
m[0]=0
for i in range(n):
    for j in range(coin[i],k+1):
            m[j]=min(m[j],m[j-coin[i]]+1)

if m[k]==10001:
    print(-1)
else:
    print(m[k])