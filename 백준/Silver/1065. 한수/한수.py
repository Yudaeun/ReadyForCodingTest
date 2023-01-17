n=int(input())
answer=[]
cnt=0
for i in range(1,n+1):
    temp=list(str(i))
    d=[]
    for k in range(len(temp)):
        if k==len(temp)-1:
            break
        else:
            d.append( int(temp[k + 1]) - int(temp[k]))
            if k==0:
                continue
            if not d[k] == d[k-1]:
                cnt+=1
print(n-cnt)