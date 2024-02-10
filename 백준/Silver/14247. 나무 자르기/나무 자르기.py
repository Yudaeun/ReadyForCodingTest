import sys
input=sys.stdin.readline

n=int(input())
h=list(map(int,input().split()))
a=list(map(int,input().split()))
tree=[]
answer=0

for i in range(n):
    tree.append([h[i],a[i]])

tree.sort(key=lambda x:x[1])

for i in range(n):
    answer+=(tree[i][0]+tree[i][1]*i)

print(answer)