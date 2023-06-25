from collections import deque

r,c=map(int,input().split())
graph=[list(str(input())) for _ in range(r)]
visited=[[0]*c for _ in range(r)]

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(x,y):
    q=deque()
    q.append((x,y))
    visited[x][y]=1
    v,k=0,0
    if graph[x][y]=='v': v+=1
    elif graph[x][y]=='k': k+=1

    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx,ny=cx+dx[i],cy+dy[i]
            if nx<0 or ny<0 or nx>=r or ny>=c: continue
            if visited[nx][ny]==0 and graph[nx][ny]=='.':
                q.append((nx,ny))
                visited[nx][ny]=1
            elif visited[nx][ny]==0 and graph[nx][ny]=='v':
                v+=1
                visited[nx][ny]=1
                q.append((nx,ny))
            elif visited[nx][ny]==0 and graph[nx][ny]=='k':
                k+=1
                visited[nx][ny]=1
                q.append((nx,ny))
    return v,k

answer=[0,0]
for i in range(r):
    for j in range(c):
        if visited[i][j]==0 and graph[i][j] in ('.','v','k'):
            v,k=bfs(i,j)
            # print(v,k)
            if v>=k: #늑대>양
                answer[1]+=v
            else:
                answer[0]+=k

print
print(*answer)