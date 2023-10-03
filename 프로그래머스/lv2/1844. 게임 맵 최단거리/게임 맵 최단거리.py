from collections import deque

def solution(maps):
    answer = 0
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    q=deque()
    q.append([0,0])
    n=len(maps)
    m=len(maps[0])
    visited=[[0]*m for i in range(n)]
    
    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if visited[nx][ny]==0 and maps[nx][ny]==1:
                visited[nx][ny]=visited[cx][cy]+1
                q.append([nx,ny])
    
    if visited[n-1][m-1]==0:
        return -1
    else:
        return visited[n-1][m-1]+1