def solution(participant, completion):
    answer = ''
    dic={}
    for p in participant:
        if not p in dic:
            dic[p]=1
        else:
            dic[p]+=1
    for c in completion:
        dic[c]-=1
    for k,v in dic.items():
        if v>=1:
            answer=k
            break
    return answer