import sys
from itertools import combinations
input=sys.stdin.readline

n=int(input())
arr=[]

def mul(arr):
    res=1
    for i in range(len(arr)):
        res*=arr[i][0]
    return res

def plus(arr):
    res=0
    for i in range(len(arr)):
        res+=arr[i][1]
    return res

for _ in range(n):
    arr.append(list(map(int,input().split())))

answer=abs(arr[0][0]-arr[0][1])

for i in range(1,n+1):
    for comb in combinations(arr,i):
        res=abs(mul(list(comb))-plus(list(comb)))
        if res<answer:
            answer=res

print(answer)