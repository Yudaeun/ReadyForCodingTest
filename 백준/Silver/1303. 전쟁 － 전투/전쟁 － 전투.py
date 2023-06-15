from collections import deque

n,m=map(int,input().split())
map=[]
for _ in range(m):
    map.append(list(str(input())))

w=0
b=0
dx=[-1,1,0,0]
dy=[0,0,-1,1]
visited=[[0]*n for _ in range(m)]

def bfs(x,y,value):
    q=deque()
    visited[x][y]=1
    q.append((x,y))
    cnt=1

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if nx<0 or ny<0 or nx>=m or ny>=n: continue
            if visited[nx][ny]==0 and map[nx][ny]==value:
                visited[nx][ny]=1
                q.append((nx,ny))
                cnt+=1
    return cnt

for i in range(m):
    for j in range(n):
        if map[i][j]=='W' and visited[i][j]==0:
            w+=pow(bfs(i,j,'W'),2)
        elif map[i][j]=='B' and visited[i][j]==0:
            b+=pow(bfs(i,j,'B'),2)

print(w,b)