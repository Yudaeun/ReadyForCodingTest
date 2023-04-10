from collections import deque
n,m,k=map(int,input().split())
num=[]
graph=[[0]*m for _ in range(n)]
for _ in range(k):
    y1,x1,y2,x2=map(int,input().split()) #1,1->1,5-1=4(x좌표) // 2,5->2-1,5-5
    for i in range(n-x2,n-x1):
        for j in range(y1,y2):
            graph[i][j]=1

dx=[-1,1,0,0]
dy=[0,0,-1,1]
visited=[[0]*m for _ in range(n)]

def inRange(x,y):
    return 0<=x<n and 0<=y<m

def bfs(x,y):
    q=deque()
    q.append([x,y])
    cnt=1
    visited[x][y]=1
    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if inRange(nx,ny) and not visited[nx][ny] and graph[nx][ny]==0:
                visited[nx][ny]=1
                q.append([nx,ny])
                cnt+=1

    return cnt

answer=0
area=[]
for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j]==0:
            area.append(bfs(i,j))
            answer+=1

print(answer)
area.sort()
print(*area)