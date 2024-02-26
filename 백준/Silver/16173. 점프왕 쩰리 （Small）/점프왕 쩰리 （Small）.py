import sys
from collections import deque
inpuy=sys.stdin.readline
n=int(input())
graph=[]
visited=[[0]*n for _ in range(n)]
for _ in range(n):
    graph.append(list(map(int,input().split())))

dx=[1,0]
dy=[0,1]

def bfs(x,y):
    q=deque()
    q.append([x,y,graph[x][y]])
    while q:
        cx,cy,cr=q.popleft()
        for i in range(2):
            nx,ny=cx+dx[i]*cr,cy+dy[i]*cr
            if 0<=nx<n and 0<=ny<n:
                if visited[nx][ny]==0:
                    if [nx,ny]==[n-1,n-1]:
                        return True
                    visited[nx][ny]=1
                    q.append([nx,ny,graph[nx][ny]])
    return False

res=bfs(0,0)

if res==True:
    print("HaruHaru")
else:
    print("Hing")