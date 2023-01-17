from collections import deque

m,n=map(int,input().split())
graph=[]
for _ in range(n):
    graph.append(list(map(int,input().split())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]
q=deque()
for i in range(n):
    for j in range(m):
        if graph[i][j]==1:
            q.append((i,j))
def bfs():
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if nx<=-1 or nx>=n or ny<=-1 or ny>=m:
                continue
            if graph[nx][ny]==0:
                q.append((nx,ny))
                graph[nx][ny]=graph[x][y]+1


bfs()
mn=0
for i in range(n):
    for j in range(m):
        if graph[i][j]==0:
            print(-1)
            exit()
        mn=max(mn,graph[i][j])
print(mn-1)