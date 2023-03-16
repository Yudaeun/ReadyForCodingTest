def solution(record):
    answer = []
    # 채팅방에서 사람이 나가면 그 닉네임으로 바껴야 함
    # 닉네임을 변경하면 로그에 남은 닉네임도 그 닉네임으로 바껴야 함
    # record만큼 루프돌면서 현재 유저 아이디를 정하고, 다시 record만큼 루프 돌면서
    # 가장 마지막에 그 유저가 행한 행동(Enter or Change)을 찾아서 딕셔너리에 저장
    # 2중 루프 끝난 뒤에(딕셔너리에 다 저장한 뒤에) 다시 record만큼 루프 돌면서
    # 메시지를 만들어서 answer 배열에 넣는다.
    
    dic={}
    for i in range(len(record)):
        record[i]=list(record[i].split(' ')) # 문자열 잘라서 다시 배열에 넣음
    
    for i in range(len(record)): # 마지막으로 유저가 행한 행동 딕셔너리에 저장 
        if record[i][0] in ('Enter','Change'):
            dic[record[i][1]]=record[i][2]
    
    
    for i in range(len(record)):
        if record[i][0]=='Enter':
            s=dic[record[i][1]]+'님이 들어왔습니다.'
            answer.append(s)
        elif record[i][0]=='Leave':
            s=dic[record[i][1]]+'님이 나갔습니다.'
            answer.append(s)
        
    return answer