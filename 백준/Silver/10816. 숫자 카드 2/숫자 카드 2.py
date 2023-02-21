import sys
input=sys.stdin.readline
n=int(input())
card=list(map(int,input().split()))
m=int(input())
sang=list(map(int,input().split()))
card.sort()
dic={}
for i in range(len(card)):
    if card[i] not in dic:
        dic[card[i]]=1
    else:
        dic[card[i]]+=1

for i in range(len(sang)):
    if sang[i] not in dic:
        print(0, end=' ')
    else:
        print(dic[sang[i]],end=' ')