def solution(num, total):
    answer = []
    mod=total%num
    if mod==0:
        for i in range((total//num)-(num//2),(total//num)+(num//2)+1):
            answer.append(i)
    else:
        for i in range((total//num)-(num//2)+1,(total//num)+(num//2)+1):
            answer.append(i)
    return answer