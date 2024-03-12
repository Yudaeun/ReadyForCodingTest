import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]
flag=False

def bfs(startLoc,cnt):
    q=deque()
    global flag,impossibleFlag
    for i in range(m):
        q.append(startLoc[i])

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if visited[nx][ny]==0 and graph[nx][ny]!=1:
                    if graph[nx][ny]==0:
                        cnt-=1
                    visited[nx][ny]+=visited[cx][cy]+1
                    if cnt<=0:
                        flag=True
                        return
                    q.append([nx,ny])
    if cnt<=0:
        flag=True
    else:
        impossibleFlag=True

virus=[]
zeroCnt=0

for i in range(n):
    for j in range(n):
        if graph[i][j]==2:
            virus.append([i,j])
        elif graph[i][j]==0:
            zeroCnt+=1

answer=1e9

if zeroCnt==0:
    print(0)
    exit()

for comb in combinations(virus,m):
    visited = [[0] * n for _ in range(n)]
    for j in range(m):
        visited[comb[j][0]][comb[j][1]]=1

    impossibleFlag=False
    bfs(comb,zeroCnt)
    if impossibleFlag:
        continue
    curMaxTime=0
    for j in range(n):
        curMaxTime=max(curMaxTime,max(visited[j]))
    answer=min(answer,curMaxTime)

if flag:
    print(answer-1)
else:
    print(-1)