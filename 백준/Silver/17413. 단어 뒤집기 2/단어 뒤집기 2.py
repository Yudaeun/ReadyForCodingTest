s=str(input())
cnt=0
start,end=0,0

def reverseWordSplit(temp):
    temp = list(temp.split(' '))
    tempstr = ''
    for j in range(len(temp)):
        if j == len(temp) - 1:
            tempstr += temp[j][::-1]
        else:
            tempstr += temp[j][::-1] + ' '
    return tempstr

for i in range(len(s)):
    if s[i]=='>':
        start=i
    elif s[i]=='<':
        if cnt==0:
            cnt+=1
            if i!=0:
                temp=s[:i]
                s=reverseWordSplit(temp)+s[i:]
            continue
        end=i
        temp = s[start + 1:end]
        s=s[:start+1]+reverseWordSplit(temp)+s[end:]

if start==0 and end==0:
    s=reverseWordSplit(s)
    start=len(s)-1

if start!=len(s)-1:
    temp = s[start + 1:]
    s=s[:start+1]+reverseWordSplit(temp)

print(s)