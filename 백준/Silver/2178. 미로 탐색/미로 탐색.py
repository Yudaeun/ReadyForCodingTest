from collections import deque

n,m=map(int,input().split())
graph=[]

for _ in range(n):
    graph.append(list(map(int,input())))



dx=[-1,1,0,0]
dy=[0,0,-1,1]
visited=[[0 for _ in range(m)] for _ in range(n)]
def bfs(x,y):
    q=deque()
    q.append((x,y))
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<=-1 or nx>=n or ny<=-1 or ny>=m:
                continue
            if graph[nx][ny]==0:
                continue
            if graph[nx][ny]>=1 and visited[nx][ny]==0:
                graph[nx][ny]=graph[x][y]+1
                visited[nx][ny]=1
                q.append((nx,ny))
bfs(0,0)
print(graph[n-1][m-1])