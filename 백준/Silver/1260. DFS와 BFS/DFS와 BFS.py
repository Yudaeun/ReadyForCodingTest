# DFS와 BFS
from collections import deque

n,m,v=map(int,input().split())
graph=[[] for _ in range(n+1)]
for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
visited=[0]*(n+1)

for i in graph:
    i.sort()

def dfs(start,graph):
    visited[start]=1
    print(start,end=' ')
    for i in graph[start]:
        if visited[i]==0:
            visited[i]=1
            dfs(i,graph)

def bfs(start,graph):
    q=deque()
    q.append(start)
    visited[start]=1
    while q:
        a=q.popleft()
        print(a,end=' ')
        for i in graph[a]:
            if visited[i]==0:
                visited[i]=1
                q.append(i)


dfs(v,graph)
visited=[0]*(n+1)
print()
bfs(v,graph)