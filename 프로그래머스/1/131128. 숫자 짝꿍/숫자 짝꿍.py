def solution(X, Y):
    answer = []
    arrX=[0 for _ in range(11)]
    arrY=[0 for _ in range(11)]
    sameNum=[0 for _ in range(11)]
    
    for num in X:
        arrX[int(num)]+=1
    
    for num in Y:
        arrY[int(num)]+=1
    
    for i in range(10):
        sameNum[i]=min(arrX[i],arrY[i])
        
        if sameNum[i]>0:
            for j in range(sameNum[i]):
                answer.append(str(i))
    
    if len(answer)==0:
        return "-1"
    else:
        answer.sort(reverse=True)
        if answer[0]=="0":
            return "0"
        else:
            return ''.join(answer)