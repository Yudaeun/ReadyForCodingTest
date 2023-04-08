n,x=map(int,input().split())
graph=[]
for i in range(n):
    graph.append(list(map(int,input().split())))
answer=0
    #세로를 가로로
for i in range(n):
    temp=[]
    for j in range(n):
        temp.append(graph[j][i])
    graph.append(temp)
for i in range(n*2):
    num=set()
    num=list(num)
    cur=graph[i][0]
    curIdx=0
    flag=0
    slide=[0]*n
    for j in range(1,n): #cur=0, j=3
        if cur!=graph[i][j]:
            if cur<graph[i][j]: #왼쪽에 경사로 설치
                if graph[i][j]-cur!=1:
                    flag=1
                    break
                if j-curIdx<x:
                    flag=1
                    break
                for k in range(j-1,j-x-1,-1):
                    if (graph[i][j]-1)!=graph[i][k] or slide[k]==1:
                        flag=1
                        break
                for k in range(j-1,j-x-1,-1):
                    slide[k]=1
                cur=graph[i][j]
                curIdx=j
            elif cur>graph[i][j]: #오른쪽에 경사로 설치
                if cur-graph[i][j]!=1:
                    flag=1
                    break
                if (j+x-1)>(n-1):
                    flag=1
                    break
                for k in range(j,j+x):
                    if (cur-1)!=graph[i][k] or slide[k]==1:
                        flag=1
                        break
                for k in range(j,j+x):
                    slide[k] = 1
                cur=graph[i][j]
                curIdx=j
    if flag==0:
        answer+=1
print(answer)