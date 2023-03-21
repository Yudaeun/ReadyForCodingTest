def solution(gems):
    answer = 999999999
    answerList=[]
    # 투포인터
    # 첨에 일단 set에 보석 다 담고 그거 갯수 센다
    # 그리고 다른 set자료형 또 만든다
    # start부터 한 개씩 늘리면서.... set에 원소 넣고 그거 갯수 셈
    # 그 체크하는 set의 갯수가 처음에 세었던 보석 종류 갯수랑 같으면 answermin갱신
    # 만약 set에 들어있는 보석갯수가 처음 보석갯수보다 작으면 end+=1
    # 만약 set에 들어있는 보석갯수가 처음 보석갯수보다 같거나 크면 start+=1
    
    gemsSet=set()
    check={}
    for gem in gems:
        gemsSet.add(gem)
    gemsNum=len(gemsSet)
    start,end=0,0
    while True:
        if start>end or end>len(gems)-1: break
        if len(check)<gemsNum:
            if not gems[end] in check:
                check[gems[end]]=1
            else:
                check[gems[end]]+=1
            end+=1

        else:
            check[gems[start]]-=1
            if check[gems[start]]==0:
                del check[gems[start]]
            start+=1
        if len(check)==gemsNum:
            if answer>(end-start):
                answer=end-start
                answerList=[start+1,end]
    if end>=len(gems):
        end=len(gems)-1 
        while start<=end:
            if gems[start] in check:
                check[gems[start]]-=1
                if check[gems[start]]==0:
                    del check[gems[start]]
            start+=1
            if len(check)==gemsNum:
                if answer>(end-start):
                    print(check)
                    answer=end-start
                    answerList=[start+1,end+1]
            
    
    
    return answerList