n,m=map(int,input().split())
s=[]
ms=[]
for _ in range(n):
    s.append(str(input()))
for _ in range(m):
    ms.append(str(input()))
cnt=0
for w in ms:
    if w in s:
        cnt+=1
    else:
        continue
print(cnt)