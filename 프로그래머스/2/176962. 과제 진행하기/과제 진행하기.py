def solution(plans):
    answer = []

    for i in range(len(plans)):
        plans[i][1]=plans[i][1].split(":")
        time=int(plans[i][1][0])*60+int(plans[i][1][1])
        plans[i][1]=time
        plans[i][2]=int(plans[i][2])

    plans.sort(key=lambda x:x[1])
    cur_time=plans[0][1]
    cur_assignment_idx=0
    stop_assignment=[]
    first_flag=False

    while True:
        # print(cur_time,answer,plans,stop_assignment,cur_assignment_idx)
        for i in range(len(plans)):
            if i==0 and first_flag==False:
                first_flag=True
                continue
            if plans[i][1]==cur_time:
                if cur_assignment_idx!=-1:
                    stop_assignment.append(cur_assignment_idx)
                cur_assignment_idx=i
                break

        cur_time+=1
        if cur_assignment_idx!=-1:
            plans[cur_assignment_idx][2]-=1

            if (plans[cur_assignment_idx][2]<=0):
                answer.append(plans[cur_assignment_idx][0])
                cur_assignment_idx=-1

                if stop_assignment:
                    cur_assignment_idx=stop_assignment.pop()

        if len(answer)==len(plans):
            break

    return answer