from collections import deque
dx=[-1,-1,-1,0,0,1,1,1]
dy=[-1,0,1,-1,1,-1,0,1]

'''
def dfs(x,y,w,h):
    graph[x][y]=0
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<=-1 or nx>=w or ny<=-1 or ny>=h:
            continue
        if graph[nx][ny]==0:
            continue
        if graph[nx][ny]==1:
            dfs(nx,ny,w,h)
'''
def bfs(x,y,w,h):
    q=deque()
    q.append((x,y))
    while q:
        x,y=q.popleft()
        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<=-1 or nx>=h or ny<=-1 or ny>=w:
                continue
            if graph[nx][ny]==1:
                graph[nx][ny]=0
                q.append((nx,ny))

while True:
    w,h=map(int,input().split())
    if w==0 and h==0:
        break
    graph=[]
    cnt=0
    for _ in range(h):
        graph.append(list(map(int,input().split())))
    for x in range(h):
        for y in range(w):
            if graph[x][y]==1:
                bfs(x,y,w,h)
                cnt+=1
    print(cnt)