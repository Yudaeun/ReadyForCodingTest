n=int(input())

graph=[]
for _ in range(n):
    graph.append(list(map(int,input().split())))
answer=[]
for i in range(len(graph)):
    cnt=0
    for j in range(len(graph)):
        if i==j:
            pass
        if graph[i][0]<graph[j][0] and graph[i][1]<graph[j][1]:
            cnt+=1
    answer.append(cnt+1)

for i in answer:
    print(i,end=' ')