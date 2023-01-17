from collections import deque
def bfs(x,y):
    visited[x][y]=1
    q=deque()
    q.append((x,y))
    while q:
        x,y=q.popleft()
        if visited[x][y] == visited[c][d]:
            return visited[x][y]-1
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<=-1 or nx>=l or ny<=-1 or ny>=l:
                continue
            if visited[nx][ny]==1:
                continue
            if visited[nx][ny]==0:
                visited[nx][ny]=visited[x][y]+1 #최단 경로 기록
                q.append((nx,ny))

dx=[1,1,2,2,-1,-1,-2,-2]
dy=[2,-2,1,-1,2,-2,1,-1] #상하좌우 대각선 좌표

t=int(input()) #테스트케이스 갯수
for i in range(t):
    count=0
    l=int(input())#체스판의 한 변의 길이
    a,b=map(int,input().split()) #나이트가 현재 있는 칸
    c,d=map(int,input().split()) #이동하려고 하는 칸
    visited=[[0]*l for _ in range(l)]
    print(bfs(a,b))