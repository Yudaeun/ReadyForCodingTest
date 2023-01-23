def solution(common):
    answer = 0
    for i in range(1,3):
        if i==1:
            checkAdd=common[i]-common[i-1]
        else:
            if checkAdd==common[i]-common[i-1]:
                answer=common[-1]+checkAdd
            else:
                for i in range(1,len(common)):
                    if common[i-1]!=0 and common[i]!=0:
                        answer=common[-1]*(common[i]//common[i-1])
                        break
    return answer