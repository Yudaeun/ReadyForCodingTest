def solution(binomial):
    answer = 0
    
    binomialSplit=binomial.split(' ')
    
    if binomialSplit[1]=='+':
        answer=int(binomialSplit[0])+int(binomialSplit[2])
    elif binomialSplit[1]=='-':
        answer=int(binomialSplit[0])-int(binomialSplit[2])
    else:
        answer=int(binomialSplit[0])*int(binomialSplit[2])
    return answer