import sys
from collections import deque
input=sys.stdin.readline

l,w=map(int,input().split())
graph=[]
for _ in range(l):
    graph.append(list(str(input())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(x,y):
    q=deque()
    q.append([x,y])
    visited=[[0]*w for _ in range(l)]
    visited[x][y]=1

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if 0<=nx<l and 0<=ny<w:
                if graph[nx][ny]=='L' and visited[nx][ny]==0:
                    visited[nx][ny]+=visited[cx][cy]+1
                    q.append([nx,ny])

    maxTime=0
    for i in range(l):
        maxTime=max(maxTime,max(visited[i]))

    return maxTime

maxTime=0
for i in range(l):
    for j in range(w):
        if graph[i][j]=='L':
            maxTime=max(maxTime,bfs(i,j))

print(maxTime-1)