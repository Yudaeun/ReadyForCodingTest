r,c,k=map(int,input().split())
graph=[]
for _ in range(r):
    graph.append(list(str(input())))

visited=[[0]*c for _ in range(r)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
ans=0

def dfs(x,y,dist):
    global ans

    visited[x][y]=1
    if dist==k and x==0 and y==c-1:
        ans+=1
        return
    if dist>k or (dist<k and x==0 and y==c-1):
        return

    for i in range(4):
        nx,ny=x+dx[i],y+dy[i]
        if nx<0 or ny<0 or nx>=r or ny>=c: continue
        if graph[nx][ny]=='T': continue
        if not visited[nx][ny]:
            dfs(nx,ny,dist+1)
            visited[nx][ny]=0

dfs(r-1,0,1)
print(ans)