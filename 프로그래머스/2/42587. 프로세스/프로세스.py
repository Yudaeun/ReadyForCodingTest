from collections import deque


def solution(priorities, location):
    answer = 0

    # dic 만들어서 각 프로세스의 우선순위를 저장
    # 이중 루프 돌면서 자신보다 높은 우선순위 프로세스가 있으면 빼서 다시 큐에 넣고
    # 없으면 프로세스 빼고 cnt를 1 증가시킨다.
    # if문으로 찾아야 하는 위치가 발견되면 종료

    dic = {}
    q = deque()

    for i in range(len(priorities)):
        dic[i] = priorities[i]  # key=위치, value=우선순위
        q.append(i)
    while True:
        cur = q.popleft()
        for i in range(len(q)):
            if dic[q[i]] > dic[cur]:
                q.append(cur)
                break
        else:
            answer += 1
            if cur == location:
                return answer

    return answer
