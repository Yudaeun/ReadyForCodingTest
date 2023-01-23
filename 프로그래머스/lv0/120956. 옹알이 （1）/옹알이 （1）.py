from itertools import permutations
def solution(babbling):
    answer = 0
    babblingList=[]
    ba=['aya','ye','woo','ma']
    result=[]
    for i in range(1,5):
        for permu in permutations(ba,i):
            babblingList.append(permu)
    for i in range(len(babblingList)):
        result.append(''.join(babblingList[i]))
    for babb in babbling:
        if babb in result:
            answer+=1
    return answer