import sys
from collections import deque

dx=[-1,1,0,0,-1,-1,1,1]
dy=[0,0,-1,1,1,-1,-1,1]

def bfs(start):
    q=deque()
    q.append(start)
    visited[start[0]][start[1]]=1

    while q:
        cx,cy=q.popleft()
        for i in range(8):
            nx,ny=cx+dx[i],cy+dy[i]
            if 0<=nx<h and 0<=ny<w:
                if visited[nx][ny]!=1 and graph[nx][ny]==1:
                    visited[nx][ny]=1
                    q.append([nx,ny])

while True:
    w,h=map(int,input().split())
    if w==0 and h==0:
        break

    graph=[]
    for _ in range(h):
        graph.append(list(map(int,input().split())))

    visited = [[0] * w for _ in range(h)]
    answer=0

    for i in range(h):
        for j in range(w):
            if graph[i][j]==1 and visited[i][j]==0:
                bfs([i,j])
                answer+=1

    print(answer)