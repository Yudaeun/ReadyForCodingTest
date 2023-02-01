from bisect import bisect_left
import sys
input=sys.stdin.readline
n=int(input())
num=list(map(int,input().split()))

lis=[]

for i in range(len(num)):
    if len(lis)==0 or lis[-1]<num[i]:
        lis.append(num[i])
    elif lis[-1]>=num[i]:
        idx=bisect_left(lis,num[i])
        lis[idx]=num[i]
print(len(lis))