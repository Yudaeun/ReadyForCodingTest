import math
dic={} # 자식: 부모
point={}

def dfs(curChild,p):
    if dic[curChild]=='-':
        if p//10<1:
            point[curChild]+=p
        else:
            parentP=p//10
            childP=p-parentP
            point[curChild]+=childP
        return
    
    parentP=p//10
    childP=p-parentP
    if parentP<1:
        childP=p
        parentP=0

    point[curChild]+=childP    
    if parentP==0:
        return
    
    dfs(dic[curChild],parentP)
    
def solution(enroll, referral, seller, amount):
    answer = []
    
    # referral=부모, enroll=자식. referral이 -이면 dfs 끝
    for i in range(len(referral)):
        dic[enroll[i]]=referral[i]
        point[enroll[i]]=0
    
    for i in range(len(seller)):
        p=amount[i]*100
        dfs(seller[i],p)
    
    for i in range(len(enroll)):
        answer.append(point[enroll[i]])
        
    return answer