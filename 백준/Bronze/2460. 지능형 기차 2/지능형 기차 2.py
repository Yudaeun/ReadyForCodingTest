total=0
answer=[]
for _ in range(10):
    off,on=map(int,input().split())
    total-=off
    total+=on
    answer.append(total)
print(max(answer))