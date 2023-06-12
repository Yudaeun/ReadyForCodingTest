import heapq

def dijk(start,end,n,graph):
    q=[]
    visited=[99999999]*(n+1)
    visited[start]=0
    heapq.heappush(q,(0,start))
    
    while q:
        dist,now=heapq.heappop(q)
        if visited[now]<dist:
            continue
        for i in graph[now]:
            if dist+i[1]<visited[i[0]]:
                visited[i[0]]=dist+i[1]
                heapq.heappush(q,(visited[i[0]],i[0]))
                
    return visited[end]

def solution(n, s, a, b, fares):
    answer = 99999999999
    # start에서 각 노드로 가는 최단 거리를 각각 구해서 dp에 저장
    # start에서 각 노드로 이동했을 때의 거리를 공통으로 하고 
    # A, B가 공통 거리 이후에 자기 집까지 가는 거리를 계산해서 최솟값 갱신
    graph=[[] for _ in range(n+1)]
    
    for i in range(len(fares)):
        c,d,f=fares[i]
        graph[c].append([d,f])
        graph[d].append([c,f])
    
    for i in range(1,n+1):
        sameRoot=dijk(s,i,n,graph)
        if sameRoot==99999999: continue
        aMin=dijk(i,a,n,graph)
        bMin=dijk(i,b,n,graph)
        # print(aMin,bMin,sameRoot,i)
        answer=min(answer,sameRoot+aMin+bMin)        
    
    return answer