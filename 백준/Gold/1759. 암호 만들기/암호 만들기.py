from itertools import combinations
l,c=map(int,input().split())
alpha=list(map(str,input().split()))
alpha.sort()
comb=list(combinations(alpha,l))

def check(comb):
    answer=[]
    for c in comb:
        mo=0
        ja=0
        for alpha in c:
            if alpha in ['a','e','i','o','u']:
                mo+=1
            else:
                ja+=1
        if mo>=1 and ja>=2:
            answer.append(c)
    return answer
answer=check(comb)
for ans in answer:
    print(''.join(ans))