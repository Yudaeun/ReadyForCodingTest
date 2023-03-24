from collections import deque
n,m=map(int,input().split())
pick=deque(list(map(int,input().split())))
num=deque([i for i in range(1,n+1)])
answer=0
while pick:
    temp=pick[0]
    if temp==num[0]:
        num.popleft()
        pick.popleft()
        continue
    tempNum1=deque([i for i in num])
    cnt=0
    cnt1,cnt2=0,0
    while tempNum1:
        if tempNum1[0]==temp:
            cnt1+=cnt
            break
        tempNum1.append(tempNum1.popleft())
        cnt += 1
    tempNum2=deque([i for i in num])
    cnt = 0
    while tempNum2:
        if tempNum2[0]==temp:
            cnt2+=cnt
            break
        tempNum2.insert(0,tempNum2.pop())
        cnt += 1
    if cnt1<=cnt2:
        num=tempNum1
        num.popleft()
        answer+=cnt1
    else:
        num=tempNum2
        num.popleft()
        answer+=cnt2
    pick.popleft()

print(answer)