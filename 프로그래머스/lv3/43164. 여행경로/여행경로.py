answer = ["ICN"]
flag=0

def dfs(depth,n,start,visited,tickets):
    global flag
    if (depth==n):
        for i in range(n):
            if visited[i]==0:
                return
        flag=1
        return
    
    for i in range(n):
        if not visited[i] and tickets[i][1]!=start and tickets[i][0]==start:
            visited[i]=1
            answer.append(tickets[i][1])
            dfs(depth+1,n,tickets[i][1],visited,tickets)
            if(flag==1):
                return
            answer.pop()
            visited[i]=0

def solution(tickets):
    # start에서 출발해서 백트래킹으로 모두 다 확인
    # 갈 수 있는 곳이 없으면 return
    n=len(tickets)
    visited=[0]*n
    tickets.sort()
    
    dfs(0,n,"ICN",visited,tickets)
    return answer