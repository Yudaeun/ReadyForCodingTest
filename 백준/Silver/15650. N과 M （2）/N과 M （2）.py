n,m=map(int,input().split())
visited=[0]*(n+1)
num=[]
def dfs(start):
    if len(num)==m:
        print(' '.join(map(str,num)))
        return
    for i in range(start,n+1):
        if visited[i]==0:
            visited[i]=1
            num.append(i)
            dfs(i)
            num.pop()
            visited[i]=0
dfs(1)