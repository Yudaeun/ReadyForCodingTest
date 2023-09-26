def solution(book_time):
    new_book_time=[]
    check=[]
    
    for i in range(len(book_time)):
        start_time=book_time[i][0].split(":")
        end_time=book_time[i][1].split(":")
        new_book_time.append([int(start_time[0])*60+int(start_time[1]),int(end_time[0])*60+int(end_time[1])])
    
    new_book_time.sort()
    
    for i in range(len(new_book_time)):
        if(len(check)==0):
            check.append(new_book_time[i])
            continue
        
        check.sort()
        
        for j in range(len(check)):
            if(check[j][1]+10<=new_book_time[i][0]):
                check[j]=new_book_time[i]
                break
        else:
            check.append(new_book_time[i])    
        
    return len(check)