s=input()
re_s=[]
i=0
copy_s=s[::-1]
rs=s
cr=''
while True:
    i+=1
    re_s=s[::-1]
    if s!=re_s:
        cr+=copy_s[-i]
        cr=cr[::-1]

        s=rs+cr
        cr=cr[::-1]

    else:
        break
print(len(s))