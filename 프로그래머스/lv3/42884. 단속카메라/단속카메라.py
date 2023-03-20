def solution(routes):
    answer = 0
    routes=sorted(routes,key=lambda x:x[1])
    temp=routes[0][1]
    
    for i in range(1,len(routes)):
        if not routes[i][1]>=temp>=routes[i][0]:
            answer+=1
            temp=routes[i][1]
        if i==len(routes)-1 and routes[i][1]>=temp>=routes[i][0]:
            answer+=1
    return answer