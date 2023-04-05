from collections import deque
n,d,k,c=map(int,input().split()) #접시수, 초밥가짓수,연속해서 먹는 접시수, 쿠폰 번호
susi=[]

for i in range(n):
    susi.append(int(input()))

tempSusi=deque(susi[:k])
susiSet=set(tempSusi)
for i in range(k):
    susi.append(susi[i])
susiSet.add(c)
maxNum=len(susiSet)
maxSusi=set(susi)
maxSusi.add(c)
maxSusiNum=len(maxSusi)

for i in range(k,n+k):
    tempSusi.popleft()
    tempSusi.append(susi[i])
    susiSet=set(tempSusi)
    susiSet.add(c)
    maxNum=max(maxNum,len(susiSet))
    if maxNum==maxSusiNum: break
print(maxNum)