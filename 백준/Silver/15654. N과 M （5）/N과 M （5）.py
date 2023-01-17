n,m=map(int,input().split())
graph=list(map(int,input().split()))
graph.sort()
num=[]
visited=[0]*(n+1)
def dfs():
    if len(num)==m:
        print(' '.join(map(str,num)))
        return
    for i in range(len(graph)):
        if visited[i]==0:
            visited[i]=1
            num.append(graph[i])
            dfs()
            num.pop()
            visited[i]=0
dfs()