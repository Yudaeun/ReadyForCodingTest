answer=[]
temp=[]
self_num=[]
for i in range(1,10000):
    temp=str(i)
    temp=list(temp)
    answer=[]
    for j in temp:
        answer.append(int(j))
    if sum(answer)+i<10000:
        self_num.append(sum(answer) + i)
    else:
        break
for i in range(1,9994):
    if i in self_num:
        pass
    else:
        print(i)