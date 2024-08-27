import sys
from collections import deque
input=sys.stdin.readline

dx=[-1,1,0,0]
dy=[0,0,-1,1]
sum_town=0
house_cnt=[]

n=int(input())

graph=[]
visited=[[0]*n for i in range(n)]
for i in range(n):
    graph.append(list(str(input())))
def bfs(x,y):
    visited[x][y]=1
    q=deque()
    q.append([x,y])
    cnt=1

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=n:
                continue
            if visited[nx][ny]==0 and graph[nx][ny]=='1':
                visited[nx][ny]=1
                q.append([nx,ny])
                cnt+=1

    return cnt


for i in range(n):
    for j in range(n):
        if graph[i][j]=='1' and visited[i][j]==0:
            house_cnt.append(bfs(i,j))
            sum_town+=1

house_cnt.sort()
print(sum_town)
for i in range(len(house_cnt)):
    print(house_cnt[i])
