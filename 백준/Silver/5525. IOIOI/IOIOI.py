n=int(input())
m=int(input())
s=str(input())

io='I'
for _ in range(n):
    io+='OI'

io_len=len(io)
cnt=0

for i in range((m-io_len)):
    #print(s[i:i+(io_len)])
    if s[i:i+(io_len)]==io:
        cnt+=1
print(cnt)