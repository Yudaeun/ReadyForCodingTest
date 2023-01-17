#카드
from collections import deque

n=int(input())
temp=[]
result=[]
card=[i for i in range(1,n+1)]
q=deque()
for i in card:
    q.append(i)
while q:
    a=q.popleft()
    print(a,end=' ')
    if len(q)==0:
        exit()
    b=q.popleft()
    q.append(b)
    result.append(a)

