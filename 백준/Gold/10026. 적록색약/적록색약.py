from collections import deque

n=int(input())
graph=[]
for _ in range(n):
    graph.append(list(str(input())))
visited=[[0 for _ in range(n)] for _ in range(n)]

cnt=0
cnt1=0

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(t,x,y):
    q=deque()
    q.append((x,y))
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if nx<=-1 or nx>=n or ny<=-1 or ny>=n:
                continue
            if visited[nx][ny]==0 and graph[nx][ny]==t:
                visited[nx][ny]=1
                q.append((nx,ny))

for i in range(n):
    for j in range(n):
        if graph[i][j]=='G' and visited[i][j]==0:
            bfs('G',i,j)
            cnt+=1
        elif graph[i][j]=='R' and visited[i][j]==0:
            bfs('R',i,j)
            cnt+=1
        elif graph[i][j]=='B' and visited[i][j]==0:
            bfs('B',i,j)
            cnt+=1

visited=[[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j]=='R':
            graph[i][j]='G'
for i in range(n):
    for j in range(n):
        if graph[i][j]=='G' and visited[i][j]==0:
            bfs('G',i,j)
            cnt1+=1
        elif graph[i][j]=='B' and visited[i][j]==0:
            bfs('B',i,j)
            cnt1+=1


print(cnt,cnt1)
