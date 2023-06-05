n=int(input())
num=[]
maxlimit=0
for i in range(n):
    num.append(list(map(int,input().split())))
    maxlimit=max(maxlimit,num[i][0])
num.sort(key=lambda x:(x[1],x[0]),reverse=True)
visited=[0]*1001
visited2=[0]*n
answer=0

for i in range(n):
    if not visited[num[i][0]]:
       visited[num[i][0]]=1
       answer+=num[i][1]
    else:
        for j in range(num[i][0],0,-1):
            if not visited[j]:
                visited[j]=1
                answer+=num[i][1]
                break

print(answer)