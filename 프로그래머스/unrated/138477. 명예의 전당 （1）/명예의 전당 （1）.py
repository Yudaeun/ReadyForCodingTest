def solution(k, score):
    answer = []
    rank=[]
        
    for sco in score:
        rank.append(sco)
        rank.sort(reverse=True)
        if(len(rank)>k):
            rank.pop()
        answer.append(rank[len(rank)-1])
        
    return answer