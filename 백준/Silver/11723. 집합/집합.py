import sys
from collections import deque

t=int(sys.stdin.readline().rstrip())
s=deque()
for _ in range(t):
    n=sys.stdin.readline().rstrip()
    ch=n.split()
    if ch[0]=='add':
        if int(ch[1]) in s:
            continue
        else:
            s.append(int(ch[1]))
    elif ch[0]=='remove':
        if not int(ch[1]) in s:
            continue
        else:
            s.remove(int(ch[1]))
    elif ch[0]=='check':
        if int(ch[1]) in s:
            print(1)
        else:
            print(0)
    elif ch[0]=='toggle':
        if int(ch[1]) in s:
            s.remove(int(ch[1]))
        else:
            s.append(int(ch[1]))
    elif ch[0]=='all':
        s=[i for i in range(1,21)]
    elif ch[0]=='empty':
        s=[]
