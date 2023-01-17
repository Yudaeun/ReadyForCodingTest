from collections import deque
t=int(input())
dx=[0,0,-1,1]
dy=[-1,1,0,0]

def bfs(x,y):
    q=deque()
    q.append((x,y))
    graph[x][y]=0
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<=-1 or nx>=m or ny<=-1 or ny>=n:
                continue
            if graph[nx][ny]==1:
                graph[nx][ny]=0
                q.append((nx,ny))

for _ in range(t):
    m,n,k=map(int,input().split())
    graph=[[0]*n for _ in range(m)]
    count=0
    for i in range(k):
        a,b=map(int,input().split())
        graph[a][b]=1

    for i in range(m):
        for j in range(n):
            if graph[i][j]==1:
                bfs(i,j)
                count+=1
    print(count)

