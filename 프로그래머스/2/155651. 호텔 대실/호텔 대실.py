def solution(book_time):
    answer = 1

    # 시간을 +10분 해서 분으로 변환하여 배열에 넣음
    # 배열 정렬(시작 시간 기준)
    # 루프 돌면서 현재 청소 중인 방들의 종료 시간>방 i의 시작 시간 이면
    # answer+1하고 만약 청소 중인 방들의 종료 시간<=방 i의 시작 시간인게 있으면
    # 그 방의 종료 시간을 갱신하고 break

    room = []
    cur_room = []

    for book in book_time:
        book = [book[0].split(":"), book[1].split(":")]
        time = [int(book[0][0]) * 60 + int(book[0][1]), int(book[1][0]) * 60 + int(book[1][1]) + 10]
        room.append(time)

    room.sort(key=lambda x: x[0])
    cur_room.append(room[0][1])
    # print(room)
    for i in range(1, len(room)):
        start = room[i][0]
        end = room[i][1]
        cur_room.sort()
        # print(cur_room,i)
        for j in range(len(cur_room)):
            if cur_room[j] > start:
                answer += 1
                cur_room.append(end)
                break
            elif cur_room[j] <= start:
                cur_room[j] = end
                break
    return answer

# print(solution([["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]))