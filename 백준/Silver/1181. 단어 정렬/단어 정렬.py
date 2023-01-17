n=int(input())

graph=[]
for _ in range(n):
    graph.append(input())

max_num=0
for i in graph:
    max_num=max(max_num,len(i))

graph=list(set(graph))
graph.sort()
for j in range(max_num+1):
    for i in graph:
        if len(i)==j:
            print(i)