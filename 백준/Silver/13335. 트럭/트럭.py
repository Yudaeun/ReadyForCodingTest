import sys
from collections import deque
input=sys.stdin.readline

n,w,l=map(int,input().split())
truck=list(map(int,input().split()))
truck.reverse()

bridge=deque([0]*w)
ans=0
while truck:
    ans+=1
    bridge.popleft()
    if sum(bridge)+truck[-1]<=l:
        bridge.append(truck.pop())
    else:
        bridge.append(0)
ans+=len(bridge)

print(ans)