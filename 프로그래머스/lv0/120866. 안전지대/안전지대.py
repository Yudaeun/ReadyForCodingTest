def solution(board):
    answer = 0
    dx=[-1,1,0,0,-1,-1,1,1]
    dy=[0,0,-1,1,-1,1,-1,1]
    trap=[]
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]==1:
                trap.append([i,j])
    
    for t in trap:
        for i in range(8):
            nx,ny=dx[i]+t[0],dy[i]+t[1]
            if nx<0 or nx>len(board)-1 or ny<0 or ny>len(board)-1:
                continue
            board[nx][ny]=1
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]==0:
                answer+=1
                
    return answer