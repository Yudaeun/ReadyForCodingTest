n=int(input())
s=str(input())
s=list(s)

start=0
end=0
check=set(s[0])
answer=0
lenS=1

while start<len(s)-1 and end<len(s)-1:
    if len(check)>n:
        start+=1
        lenS-=1
        answer=max(answer,lenS)
        check=set(s[start:end+1])
    else:
        end+=1
        lenS+=1
        check.add(s[end])

if len(check)>n:
    answer=max(answer,lenS-1)
else:
    answer=max(answer,lenS)
print(answer)