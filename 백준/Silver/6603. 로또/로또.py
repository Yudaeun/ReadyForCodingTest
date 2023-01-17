def dfs(start):
    if len(num)==6:
        print(' '.join(map(str,num)))
        return
    for i in range(start,len(k)):
        if visited[i]==0:
            visited[i]=1
            num.append(k[i])
            dfs(i)
            num.pop()
            visited[i]=0

while True:
    k=list(map(int,input().split()))
    if k[0]==0:
        break
    num=[]
    cnt=0
    k=k[1:]
    visited=[0]*(len(k)+1)
    dfs(0)
    print()
