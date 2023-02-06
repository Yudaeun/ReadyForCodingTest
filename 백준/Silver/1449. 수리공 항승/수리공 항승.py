n,l=map(int,input().split())
num=list(map(int,input().split()))

num.sort()
tape=1
answer=0
if l==1:
    print(n)
    exit()
current=num[0]-0.5
first=num[0]-0.5

for i in range(n):
    current=num[i]+0.5
    if current-first==l:
        answer+=1
        if i!=n-1:
            first=num[i+1]-0.5
        else:
            print(answer)
            exit()
    elif current-first>l:
        answer+=1
        first=num[i]-0.5
print(answer+1)