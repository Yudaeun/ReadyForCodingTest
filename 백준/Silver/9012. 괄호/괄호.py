t=int(input())
for _ in range(t):
    vps=input()
    for i in range(len(vps)//2+1):
        vps=vps.replace('()','')
    if len(vps)==0:
        print('YES')
    else:
        print('NO')