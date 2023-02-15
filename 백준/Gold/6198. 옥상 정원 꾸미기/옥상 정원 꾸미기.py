import sys
input=sys.stdin.readline
n=int(input())
num=[]
for i in range(n):
    num.append(int(input()))

num.append(sys.maxsize)
count=[0]*(n+1)
st=[]
for i in range(n):
    while len(st)!=0 and (num[st[-1]]<=num[i]):
        idx=st.pop()
        count[idx]=i-idx-1
    if len(st)!=0 and num[st[-1]]==num[i]:
        st.pop()
    st.append(i)

while st:
    idx=st.pop()
    count[idx]=(n-1)-idx

print(sum(count))