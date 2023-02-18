n=int(input())
num=list(map(int,input().split()))

num.reverse()
answer=[0]*(n)
st=[]
for i in range(n):
    while len(st)!=0 and num[st[-1]]<=num[i]:
        idx=st.pop()
        answer[(n-1)-idx]=(n-i)
    st.append(i)
print(*answer)