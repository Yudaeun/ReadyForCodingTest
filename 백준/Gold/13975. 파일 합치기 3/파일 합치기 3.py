import sys
import heapq
input=sys.stdin.readline
t=int(input())

for test in range(1,t+1):
    k=int(input())
    num=list(map(int,input().split()))
    answer=0
    heapq.heapify(num)

    while num:
        file1=heapq.heappop(num)
        if len(num)>0:
            file2=heapq.heappop(num)
            heapq.heappush(num,file1+file2)
            answer+=file1+file2
        else:
            break
    print(answer)