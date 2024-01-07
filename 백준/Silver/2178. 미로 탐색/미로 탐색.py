from collections import deque

n,m=map(int,input().split())
map=[]

for _ in range(n):
    map.append(list(str(input())))

visited=[[0]*m for _ in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(startX,startY):
    visited[startX][startY]=1
    q=deque()
    q.append((startX,startY))

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if map[nx][ny]=='1' and visited[nx][ny]==0:
                visited[nx][ny]=visited[cx][cy]+1
                q.append((nx,ny))
    return visited[n-1][m-1]

print(bfs(0,0))