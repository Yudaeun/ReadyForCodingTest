from collections import deque
n=int(input())
d=deque()
y=deque()
for i in range(n):
    d.append(input())

for i in range(n):
    y.append(input())

cnt=0
q=deque()
while d:
    if d[0]!=y[0]:
        cnt+=1
        d.remove(y.popleft())
    else:
        d.popleft()
        y.popleft()
print(cnt)