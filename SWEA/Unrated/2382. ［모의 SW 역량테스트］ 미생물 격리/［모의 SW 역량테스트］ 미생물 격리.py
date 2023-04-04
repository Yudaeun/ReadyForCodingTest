'''
k개의 미생물 군집, n*n 맵
가장자리에 특수한 약품
[미생물군집 위치, 미생물의 수, 이동방향] 이동방향=상하좌우
1. 1시간 마다 미생물 군집은 이동방향쪽으로 이동한다.
2. 만약 가장자리에 도착하면 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다. 남은 미생물=원래미생물//2
3. 미생물 수가 0이 되면 군집이 사라진다.
4. 이동이 끝난 뒤, 군집이 한 셀에 모이면 군집이 합쳐진다.->미생물 수 합하기. 이동방향은 미생물 수가 많은애로
5. M시간 후 남아있는 미생물 수?
'''

dx=[-1,1,0,0] #상하좌우
dy=[0,0,-1,1]

# 1시간동안 미생물 전부 이동시키는 함수
def move():
    for time in range(m):
        tempBug = []
        for i in range(k):
            if bug[i][2]<=0: continue
            x=bug[i][0]+dx[bug[i][3]]
            y=bug[i][1]+dy[bug[i][3]]
            bug[i][0]=x
            bug[i][1]=y
            if x<=0 or y<=0 or x>=n-1 or y>=n-1:
                if bug[i][3]<=1:
                    bug[i][3]=(bug[i][3]+1)%2
                else:
                    if bug[i][3]==2: bug[i][3]=3
                    elif bug[i][3]==3: bug[i][3]=2
                bug[i][2]//=2
                if bug[i][2]<=0:
                    continue
                tempBug.append(bug[i])
            else:
                tempBug.append(bug[i])

        for i in range(len(tempBug)):
            bugCnt=[tempBug[i][2],tempBug[i][3]]
            sumBug=[tempBug[i][0],tempBug[i][1],tempBug[i][2]]
            for j in range(i+1,len(tempBug)):
                if tempBug[i][0]==tempBug[j][0] and tempBug[i][1]==tempBug[j][1]:
                    sumBug[2]+=tempBug[j][2]
                    if tempBug[j][2]>bugCnt[0]:
                        bugCnt[1]=tempBug[j][3]
                        bugCnt[0]=tempBug[j][2]
            flag=0
            if sumBug[2]==tempBug[i][2]: continue
            for j in range(len(bug)):
                if flag==0 and sumBug[0]==bug[j][0] and sumBug[1]==bug[j][1]:
                    bug[j][3]=bugCnt[1]
                    bug[j][2]=sumBug[2]
                    flag=1
                elif flag==1 and sumBug[0]==bug[j][0] and sumBug[1]==bug[j][1]:
                  bug[j][3]=bugCnt[1]
                  bug[j][2]=0

t=int(input())

for time in range(1,t+1):
    n,m,k=map(int,input().split()) #n=맵크기 m=시간 k=미생물 수
    graph=[[0]*n for _ in range(n)]
    bug=[]
    for i in range(k): #미생물 군집의 수
        bug.append(list(map(int,input().split()))) #x,y,미생물 수, 이동방향
        bug[i][3]-=1
    move()
    answer=0
    for i in range(k):
        answer+=bug[i][2]
    print("#{} {}".format(time,answer))