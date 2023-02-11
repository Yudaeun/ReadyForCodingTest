n=int(input())
meeting=[]
for i in range(n):
    meeting.append(list(map(int,input().split())))

meeting=sorted(meeting,key=lambda x:(x[1],x[0]))
answer=0
current=meeting[0][1]

for i in range(1,n):
    if current<=meeting[i][0]:
        current=meeting[i][1]
        answer+=1

print(answer+1)