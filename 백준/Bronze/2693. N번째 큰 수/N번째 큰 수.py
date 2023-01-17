answer=[]
t=int(input())
for _ in range(t):
    n=list(map(int,input().split()))
    n.sort(reverse=True)
    answer.append(n[2])

for i in answer:
    print(i)