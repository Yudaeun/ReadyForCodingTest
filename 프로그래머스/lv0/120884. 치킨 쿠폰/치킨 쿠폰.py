def solution(chicken):
    answer = 0
    mod=0
    while chicken>=10:
        div=chicken//10
        answer+=div
        chicken=(chicken%10)+div
        
        
    
    return answer