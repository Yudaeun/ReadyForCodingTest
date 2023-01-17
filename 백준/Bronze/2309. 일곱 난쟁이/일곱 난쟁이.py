answer=[]
height=[]
for _ in range(9):
    n=int(input())
    height.append(n)

total=sum(height)
count,count1=0,0
for i in height:
    answer=0
    count1=0
    count+=1
    for j in height:
        answer=total-i-j
        count1+=1
        if count==count1:
            continue
        if answer==100:
            height.remove(i)
            height.remove(j)
            height.sort()
            for a in range(len(height)):
                print(height[a])
            exit()