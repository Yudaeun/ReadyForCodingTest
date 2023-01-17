from collections import deque
import sys

t=int(sys.stdin.readline())

for _ in range(t):
    p=sys.stdin.readline().strip()
    p=list(p) 
    n=int(sys.stdin.readline())
    num=sys.stdin.readline().strip()
    if num=='[]':
        if 'D' in p:
            print('error')
        else:
            print(num)
        continue

    num=num.replace('[','')
    temp=''
    q=deque()
    for i in num:
        if i==',' or i==']':
            q.append(temp)
            temp=''
        else:
            temp+=i
    cnt=0
    for i in range(len(p)):
        if p[i]=='D':
            if len(q)==0:
                print('error')
                break
            else:
                if cnt%2==0:
                    q.popleft()
                else:
                    q.pop()
        elif p[i]=='R':
            cnt+=1
        if i==len(p)-1:

            if cnt%2==0:
                print("["+",".join(list(q))+"]")
            else:
                q=list(q)
                q=q[::-1]
                print("["+",".join(q)+"]")
