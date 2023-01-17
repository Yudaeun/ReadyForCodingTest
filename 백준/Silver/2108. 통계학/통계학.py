from collections import Counter
import sys

n=int(sys.stdin.readline())
num=[]
for _ in range(n):
    num.append(int(sys.stdin.readline()))
print(round(sum(num)/n))
num.sort()
print(num[n//2])

many=Counter(num)
mv=max(list(many.values()))
cnt=0
temp=[]
for k,v in many.items():
    if v==mv:
        cnt+=1
        temp.append(k)
temp.sort()
if cnt==1:
    print(temp[0])
else:
    print(temp[1])

print(max(num)-min(num))