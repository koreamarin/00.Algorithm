for _ in range(int(input())) :
    i=0
    S=input()
    for s in S :
        if s == "(" :
            i+=1
        elif s == ")" :
            i-=1
            if i < 0:
                print("NO")
                break
    if i>=0:
        print('YES' if i==0 else 'NO')