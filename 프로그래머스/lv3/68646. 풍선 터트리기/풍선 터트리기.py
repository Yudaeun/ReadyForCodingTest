def solution(a):
    answer = 0
    # 현재 나의 원소 기준으로 왼쪽, 오른쪽을 봤을 때 왼쪽에서 가장 작은 원소와 오른쪽에서 가장 작은 원소 둘 중 하나만 현재 원소보다 작으면 됨
    # 2중 루프 돌면 절 대 안됨
    # 현재 원소까지의 가장 작은 값을 배열 두 개에 저장해두고 사용
    sum1=[]
    sum2=[]
    minN=9000000000
    for i in range(len(a)):
        minN=min(minN,a[i])
        sum1.append(minN)
        
    minN=9000000000
    for i in range(len(a)-1,-1,-1):
        minN=min(minN,a[i])
        sum2.append(minN)
    sum2.reverse()
    
    for i in range(len(a)):
        if a[i]>sum1[i] and a[i]>sum2[i]:
            continue
        answer+=1
        
    return answer