s=int(input())
sum=0
count=0
if s==1 or s==2:
    print(1)
    exit()
elif s==3:
    print(2)
    exit()

for i in range(1,s+1):
    sum += i
    count += 1

    if sum>=s:
        if sum>s:
            print(count-1)
            exit()
        print(count)
        break