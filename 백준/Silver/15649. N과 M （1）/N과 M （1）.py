from itertools import permutations

n,m=map(int,input().split())
num=[i for i in range(1,n+1)]
comb=list(permutations(num,m))

for i in comb:
    for j in i:
        print(j, end=' ')
    print()