a,b=map(int,input().split())
answer=0
num=[0]
for i in range(1,1002):
    for j in range(i):
        num.append(i)
        if len(num)==1002:
            break
    if len(num)==1002:
        break

for i in range(a,b+1):
    answer+=num[i]
print(answer)