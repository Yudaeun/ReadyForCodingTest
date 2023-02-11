n,m=map(int,input().split())
guitarPackage=[]
guitarOne=[]
for _ in range(m):
    a,b=map(int,input().split())
    guitarPackage.append(a) #6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격
    guitarOne.append(b)

guitarPackage.sort()
guitarOne.sort()

answer=0

if n>=6:
    packageNum=(n//6)
    mod=n%6
    answer=min(guitarPackage[0]*packageNum,guitarOne[0]*6*packageNum)
    answer+=min(guitarOne[0]*mod,guitarPackage[0])
else:
    answer=min(guitarOne[0]*n,guitarPackage[0])

print(answer)
