from collections import deque

dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y,k,n,visited):
    q=deque()
    q.append((x,y))
    visited[x][y]=1
    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx=dx[i]+cx
            ny=dy[i]+cy
            if nx<=-1 or nx>=n or ny<=-1 or ny>=n:
                continue
            if visited[nx][ny]==0 and graph[nx][ny]>k:
                q.append((nx,ny))
                visited[nx][ny]=1


n=int(input())
graph=[]
for _ in range(n):
    graph.append(list(map(int,input().split())))
maxNum=0
for i in range(n):
    for j in range(n):
        maxNum=max(maxNum,graph[i][j])

visited=[[0 for _ in range(n)] for _ in range(n)]
cnt=0
answer=0
for k in range(1,maxNum+1):
    for i in range(n):
        for j in range(n):
            if graph[i][j]<=k:
                visited[i][j]=-1
            if visited[i][j]==0:
                cnt+=1
                bfs(i,j,k,n,visited)
    visited = [[0 for _ in range(n)] for _ in range(n)]
    answer=max(answer,cnt)
    cnt = 0
if answer==0: answer=1
print(answer)