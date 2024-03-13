def solution(bandage, health, attacks):
    answer = 0
    curIdx=0
    cnt=0
    maxHealth=health
    
    for i in range(attacks[-1][0]+1):
        # print(health)
        if i==attacks[curIdx][0]:
            health-=attacks[curIdx][1]
            curIdx+=1
            cnt=0
            if health<=0:
                return -1
            continue
        cnt+=1
        health+=bandage[1]
        
        if cnt==bandage[0]:
            cnt=0
            health+=bandage[2]
            
        if health>=maxHealth:
            health=maxHealth
        
    return health