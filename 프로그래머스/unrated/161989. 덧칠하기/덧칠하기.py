def solution(n, m, section):
    answer = 0
    paint=[0]*(n+1)
    
    # for i in range(1,n+1):
    #     if paint[i]==1: continue
    #     if i in section:
    #         answer+=1
    #         for j in range(i,i+m):
    #             if j>n: break
    #             paint[j]=1
    cur=section.pop()
    while section:
        temp=section.pop()
        if cur-temp>=m:
            answer+=1
            cur=temp
        
    
    return answer+1