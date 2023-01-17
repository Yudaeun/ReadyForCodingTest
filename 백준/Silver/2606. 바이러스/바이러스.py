n=int(input())
m=int(input())
graph=[[] for _ in range(n+1)]
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

v=1
count=0
visited=[0]*(n+1)
for i in range(len(graph)):
    graph[i].sort()

def dfs(v):
    global count
    visited[v]=1
    for i in graph[v]:
        if not visited[i]:
            dfs(i)
            count+=1

dfs(v)
print(count)