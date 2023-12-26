from itertools import permutations

n=int(input())
cnt=list(map(int,input().split()))
people=[0 for _ in range(n)]

for i in range(n):
    num=0
    for j in range(n):
        if people[j]==0:
            num+=1
        if num==cnt[i]+1:
            people[j]=(i+1)
            break

print(*people)