import sys
sys.setrecursionlimit(10**7)
n=int(input())
#DFS 사용
graph=[]
for i in range(n):
    graph.append(list(map(int,input())))

def dfs(x,y):
    global count
    if x<=-1 or x>=n or y<=-1 or y>=n:
        return False
    if graph[x][y]==1:
        graph[x][y]=0 #방문처리
        count+=1
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1) #상하좌우
        return True
    return False
answer=[] #단지내 집의 수
result=0 #총 단지수
for i in range(n):
    for j in range(n):
        count=0
        if dfs(i,j)==True:
            result+=1
            answer.append(count)
print(result)
answer.sort()
for i in answer:
    print(i)
