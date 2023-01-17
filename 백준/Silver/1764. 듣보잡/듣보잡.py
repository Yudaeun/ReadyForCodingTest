import sys
n,m=map(int,sys.stdin.readline().split())
graph1=[]
graph2=[]
for _ in range(n):
    graph1.append(input())
for _ in range(m):
    graph2.append(input())

graph1=set(graph1)
graph2=set(graph2)
answer=list(graph1 & graph2)
answer.sort()
print(len(answer))
for i in answer:
    print(i)