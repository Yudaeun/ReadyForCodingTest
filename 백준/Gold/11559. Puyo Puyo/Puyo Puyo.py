from collections import deque
#뿌요가 아래로 떨어지는 함수=down()
#연쇄되는 함수=rush()
buyo=[]
dx=[-1,1,0,0]
dy=[0,0,-1,1]

for _ in range(12):
    buyo.append(list(str(input())))

def down():
    for i in range(11,0,-1):
        for j in range(6):
            if buyo[i][j]=='.' and (buyo[i-1][j] in ('R','G','B','P','Y')):
                buyo[i][j]=buyo[i-1][j]
                buyo[i-1][j]='.'
def rush():
    flag=0
    for i in range(12):
        for j in range(6):
            if buyo[i][j] in ('R','G','B','P','Y'):
                color=buyo[i][j]
                rushBuyo=set()
                rushBuyo.add((i,j))
                q=deque()
                q.append([i,j])
                visited=[[0]*6 for _ in range(12)]
                visited[i][j]=1
                while q:
                    cx,cy=q.popleft()
                    for k in range(4):
                        nx=cx+dx[k]
                        ny=cy+dy[k]
                        if nx<0 or nx>=12 or ny<0 or ny>=6: continue
                        if buyo[nx][ny]==color and visited[nx][ny]==0:
                            rushBuyo.add((nx,ny))
                            q.append([nx,ny])
                            visited[nx][ny]=1
                if len(rushBuyo)>=4:
                    flag=1

                    for x,y in rushBuyo:
                        buyo[x][y]='.'
    return flag

answer=0
while True:
    for i in range(12):
        down()
    
    checkFlag=rush()
    if(checkFlag==0):
        break
    answer+=1
print(answer)