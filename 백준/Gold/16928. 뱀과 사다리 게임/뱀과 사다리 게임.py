import sys
from collections import deque
input= sys.stdin.readline

n,m=map(int,input().split())
ladder=[]
snake=[]

for _ in range(n):
    ladder.append(list(map(int,input().split())))

for _ in range(m):
    ladder.append(list(map(int,input().split())))

visited=[0]*100

def bfs():
    q=deque()
    q.append(0)

    while q:
        cx=q.popleft()
        if cx==99:
            print(visited[cx])
            exit()
        for i in range(1,7):
            nx=cx+i
            if nx<100 and visited[nx]==0:
                for j in range(len(ladder)):
                    if ladder[j][0]-1==nx:
                        nx=ladder[j][1]-1
                if visited[nx]==0:
                    visited[nx]=visited[cx]+1
                    q.append(nx)

bfs()