import sys
from itertools import permutations
n=int(input())
a=list(map(int,input().split()))
o=list(map(int,input().split()))

oper=[]
for i in range(4):
    if i==0:
        for j in range(o[i]):
            oper.append('+')
    elif i==1:
        for j in range(o[i]):
            oper.append('-')
    elif i==2:
        for j in range(o[i]):
            oper.append('*')
    else:
        for j in range(o[i]):
            oper.append('%')
result=[]
per=list(set(list(permutations(oper,len(oper)))))
for p in per:
    sum=a[0]
    for i in range(len(p)):
        if p[i]=='+':
            sum+=a[i+1]
        elif p[i]=='-':
            sum-=a[i+1]
        elif p[i]=='*':
            sum*=a[i+1]
        elif p[i]=='%':
            if ( sum<0 and a[i+1]<0 ) or (sum>0 and a[i+1]>0):
                sum//=a[i+1]
            elif sum<0 or a[i+1]<0:
                sum=-(abs(sum)//abs(a[i+1]))
    result.append(sum)
print(max(result))
print(min(result))