import heapq
import sys
input=sys.stdin.readline
n=int(input())
num=[]
for _ in range(n):
    x=int(input())
    if x!=0:
        heapq.heappush(num,[abs(x),x])
    else:
        if num:
            a=heapq.heappop(num)
            print(a[1])
        else:
            print(0)