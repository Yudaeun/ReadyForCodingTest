k=int(input())
num=[]
if k==1:
    a=int(input())
    print(a)
    exit()
for i in range(k):
    a=int(input())
    if a==0:
        num.pop()
    else:
        num.append(a)

print(sum(num))