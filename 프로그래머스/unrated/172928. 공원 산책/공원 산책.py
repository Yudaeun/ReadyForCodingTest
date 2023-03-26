dx=[-1,1,0,0]
dy=[0,0,-1,1]

def searchStart(park):
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j]=='S':
                return [i,j]

def move(park,x,y,length,dist):
    while length>0:
        length-=1
        x+=dx[dist]
        y+=dy[dist]
        if x<0 or x>=len(park) or y<0 or y>=len(park[0]):
            return [-1,-1]
        if park[x][y]=='X':
            return [-1,-1]
    
    return [x,y]
            
def check(park,routes,x,y):
    for route in routes:
        route=list(map(str,route.split(' ')))
        if route[0]=='N':
            dist=0
        elif route[0]=='S':
            dist=1
        elif route[0]=='W':
            dist=2
        else:
            dist=3
                    
        tempX,tempY=move(park,x,y,int(route[1]),dist)
        if tempX==-1: continue
        else: x,y=tempX,tempY
    return [x,y]
        
            
            
def solution(park, routes):
    answer = []
    x,y=searchStart(park)
    answer=check(park,routes,x,y)
    
    return answer