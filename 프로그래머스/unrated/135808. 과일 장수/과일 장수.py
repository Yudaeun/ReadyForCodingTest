def solution(k, m, score):
    answer = 0
    min_score=99999999
    
    score.sort(reverse=True)
    
    for i in range(len(score)):
        if(i%m==0 and i>0):
            answer+=m*min_score
            min_score=99999999
        
        min_score=min(min_score,score[i])
    
    if (len(score)%m==0):
        answer+=m*min_score
    
    return answer