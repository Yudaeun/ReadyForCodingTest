import sys
input=sys.stdin.readline

s,e,q=map(str,input().split())

s=s.split(":")
e=e.split(":")
q=q.split(":")

s=s[0]*60+s[1]
e=e[0]*60+e[1]
q=q[0]*60+q[1]
answer=set()
onecheck=set()

while True:
    try:
        time,nickname=map(str,input().split())
        time=time.split(":")
        time=time[0]*60+time[1]

        if time<=s:
            onecheck.add(nickname)
        if time>=e and time<=q:
            if nickname in onecheck:
                answer.add(nickname)

    except:
        break

print(len(answer))