one,zero=0,0

def solution(arr):
    answer = []
    
    def check(x,y,size):
        temp=arr[x][y]
        for i in range(x,x+size):
            for j in range(y,y+size):
                if temp!=arr[i][j]:
                    return False;
        return True;
    
    def dfs(x,y,size):
        global one,zero
        if check(x,y,size):
            if arr[x][y]==1:
                one+=1
            else: zero+=1
            return
        
        newSize=size//2
        dfs(x,y,newSize)
        dfs(x,y+newSize,newSize)
        dfs(x+newSize,y,newSize)
        dfs(x+newSize,y+newSize,newSize)
    dfs(0,0,len(arr))
        
    return zero,one