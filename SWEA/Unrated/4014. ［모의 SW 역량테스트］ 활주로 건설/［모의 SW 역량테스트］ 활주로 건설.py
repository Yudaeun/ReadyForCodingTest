'''
n*n맵에 활주로를 건설
숫자=그 지형의 높이
활주로를 가로or세로로 건설할 수 있는 가능성을 확인
활주로는 높이가 동일한 구간에만 건설
높이가 다르다면 경사로를 설치한다. 경사로는 길이x, 높이1
경사로는 높이차가 1이고, 낮은 지형의 높이가 경사로의 길이만큼 같은 높이를 가져야함
가로 세로를 다 확인해서 전체를 같은 높이로 만들어야 함

제대로 경사로를 설치할 수 있으면 거기는 1로 둠. 그 행이나 열의 숫자를 set에 다 넣음
list로 만들고 내림차순 정렬
만약에 set의 길이가 1이면 그냥 answer++
가장 높은 거 부터 앞이랑 뒤에 경사로를 설치한다.
만약에 해당 길이보다 더 낮은게 앞에 없으면 뒤에만 경사로를 설치하면 된다
경사로가 맵을 벗어나면 안된다
경사로 설치하는 곳의 열이 전부 같은 높이여야 한다
경사로를 설치하면 했다고 1로 설정하고, 가장 마지막 인덱스+1부터 또 확인한다
'''

t=int(input())
for test in range(1,t+1):
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

    print("#{} {}".format(test,answer))

