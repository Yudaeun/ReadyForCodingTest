from itertools import permutations

k=int(input())
s=str(input())
s=s.replace(' ','')
num=[i for i in range(10)]
result=list(permutations(num,k+1))
result.sort()
answer=[]

for i in range(len(result)-1,-1,-1):
    temp=[result[i][0]]
    for j in range(len(s)):
        if s[j]=='<' and temp[j]<result[i][j+1]:
            temp.append(result[i][j+1])
        elif s[j]=='>' and temp[j]>result[i][j+1]:
            temp.append(result[i][j+1])
        else:
            break
    else:
        answer.append(temp)
        break

for i in range(len(result)):
    temp=[result[i][0]]
    for j in range(len(s)):
        if s[j]=='<' and temp[j]<result[i][j+1]:
            temp.append(result[i][j+1])
        elif s[j]=='>' and temp[j]>result[i][j+1]:
            temp.append(result[i][j+1])
        else:
            break
    else:
        answer.append(temp)
        break

for ans in answer:
    print(''.join(str(i) for i in ans))