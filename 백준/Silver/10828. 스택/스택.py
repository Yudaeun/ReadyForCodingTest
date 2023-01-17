import sys
n=int(sys.stdin.readline().rstrip())
stack=[]
for _ in range(n):
    check=sys.stdin.readline().rstrip()
    temp=list(check.split())
    if temp[0]=='push':
        stack.append(temp[1])
    elif temp[0]=='pop':
        if len(stack)==0:
            print(-1)
        else:
            a=stack.pop()
            print(a)
    elif temp[0]=='size':
        print(len(stack))
    elif temp[0]=='empty':
        if len(stack)==0:
            print(1)
        else:
            print(0)
    elif temp[0]=='top':
        if len(stack)==0:
            print(-1)
        else:
            print(stack[-1])