
n=int(input())
words=[]
for _ in range(n):
    words.append(str(input()))


cnt=0
for word in words:
    temp='0'
    check=[]
    for w in word:

        if temp!=w:

            temp=w
            if temp in check:
                break
            else:
                check.append(temp)
    else:
        cnt+=1

print(cnt)