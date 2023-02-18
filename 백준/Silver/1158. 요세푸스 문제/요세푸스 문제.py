from collections import deque
n,k=map(int,input().split())
answer=[]
q=deque([i for i in range(1,n+1)])
cnt=0
while q:
    cnt+=1
    if cnt==k:
        cnt=0
        answer.append(q.popleft())
    else:
        q.append(q.popleft())

s=''
s+='<'
for i in range(n-1):
    s+=str(answer[i])
    s+=', '
s+=str(answer[-1])+'>'
print(s)