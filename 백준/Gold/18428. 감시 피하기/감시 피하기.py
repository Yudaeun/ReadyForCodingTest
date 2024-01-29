from itertools import permutations

dx=[-1,1,0,0]
dy=[0,0,-1,1]
n=int(input())
graph=[]

def check(graph,teacher):
    for i in range(len(teacher)):
        for j in range(4):
            cx, cy = teacher[i][0], teacher[i][1]

            while 0<=cx<n and 0<=cy<n:
                cx+=dx[j]
                cy+=dy[j]
                if not 0<=cx<n or not 0<=cy<n:
                    break
                if graph[cx][cy]=='O':
                    break
                elif graph[cx][cy]=='S':
                    return False
    return True

for _ in range(n):
    graph.append(list(map(str,input().split())))

xLoc=[]
teacher=[]

for i in range(n):
    for j in range(n):
        if graph[i][j]=='X':
            xLoc.append([i,j])
        elif graph[i][j]=='T':
            teacher.append([i,j])

for perm in permutations(xLoc,3):
    for i in range(3):
        graph[perm[i][0]][perm[i][1]]='O'

    if check(graph,teacher):
        print("YES")
        exit()

    for i in range(3):
        graph[perm[i][0]][perm[i][1]]='X'

print("NO")