import sys
from collections import deque
input=sys.stdin.readline
n=int(input())
maxHeight=0
minHeight=sys.maxsize
answer=0
num=[]
dx=[-1,1,0,0]
dy=[0,0,-1,1]

for i in range(n):
    num.append(list(map(int,input().split())))

for i in range(n):
    for j in range(n):
        maxHeight=max(maxHeight,num[i][j])
        minHeight=min(minHeight,num[i][j])

def bfs(h, x, y):
    q=deque()
    q.append((x,y))
    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=n:
                continue
            if num[nx][ny]>h and visited[nx][ny]==0:
                q.append((nx,ny))
                visited[nx][ny]=1

for h in range(maxHeight):
    visited=[[0]*n for _ in range(n)]
    tempSum=0
    for i in range(n):
        for j in range(n):
            if (num[i][j]>h and visited[i][j]==0):
                bfs(h,i,j)
                tempSum+=1
    answer=max(answer,tempSum)
print(answer)