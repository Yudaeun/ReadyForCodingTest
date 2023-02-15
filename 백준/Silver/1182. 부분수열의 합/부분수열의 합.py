import sys
from itertools import combinations
input=sys.stdin.readline
n,s=map(int,input().split())
num=list(map(int,input().split()))
answer=0
for i in range(1,n+1):
    for comb in combinations(num,i):
        if sum(comb)==s:
            answer+=1
print(answer)