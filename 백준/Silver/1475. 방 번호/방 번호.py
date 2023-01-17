n=input()
num=list(n)
cnt=0
answer=[0]*10
for i in num:
    if int(i)==9 or int(i)==6:
        cnt+=1
    elif int(i) in [0,1,2,3,4,5,7,8]:
        answer[int(i)]+=1
    if cnt==2:
        answer[6]+=1
        cnt=0
if cnt==1:
    answer[6]+=1
print(max(answer))