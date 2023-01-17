n=int(input())
m=list(map(int,input().split()))
count=0

for i in m:
    if i==1:
        count+=1
    for j in range(2,i):
        if i%j==0:
            count+=1
            break
print(len(m)-count)