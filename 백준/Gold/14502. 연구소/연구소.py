'''
루프 돌면서 0인 위치에 벽을 하나씩 세우고(3중 루프)
3중 루프문 안에서 또 루프 돌면서 BFS 쓰고, 리스트 안에서 0의 개수를 count한다.
시간 제한 2초에 N와 M의 제한이 8까지밖에 안 되기 때문에 O(N^4)여도 괜찮다. 아마도
'''
import copy
from collections import deque

n,m=map(int,input().split())
graph=[]
q=deque()
wall=[]
q_list=[]
for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(m):
        if graph[i][j]==2:
            q.append((i,j))
            q_list.append((i,j))
        if graph[i][j]==0:
            wall.append((i,j))
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs():
    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<=-1 or nx>=n or ny<=-1 or ny>=m:
                continue
            if graph[nx][ny]==0:
                graph[nx][ny]=2
                q.append((nx,ny))

cnt=0
max_num=0
copy_graph=copy.deepcopy(graph)
for i in range(len(wall)):
    for j in range(i+1, len(wall)):
        for k in range(j+1, len(wall)):
            graph = copy.deepcopy(copy_graph)
            q.extend(q_list)
            a,b=wall[i]
            c,d=wall[j]
            e,f=wall[k]
            graph[a][b]=1
            graph[c][d]=1
            graph[e][f]=1
            bfs()
            one_graph=sum(graph,[])
            max_num=max(max_num,one_graph.count(0))
            graph[a][b]=0
            graph[c][d] = 0
            graph[e][f] = 0
print(max_num)