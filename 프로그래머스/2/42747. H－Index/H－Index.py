def solution(citations):
    answer = 0
    cur_cnt=0
    citations.sort()
    # print(citations)

    while True:
        min_num=0
        for i in range(len(citations)):
            if citations[i]<=cur_cnt:
                min_num+=1
            if citations[i]>=cur_cnt:
                max_num=len(citations)-i

                if min_num<=cur_cnt and max_num>=cur_cnt:
                    answer=cur_cnt
                break
        cur_cnt+=1
        if cur_cnt>citations[-1]:
            break

    return answer
