T=int(input())
for t in range(1, T+1):
    W=[i for i in input()]
    for i in range(len(W)//2):
        W[i],W[-(1+i)]=W[-(1+i)],W[i]
    for i in range(len(W)):
        if W[i]=='b':
            W[i]='d'
        elif W[i]=='d':
            W[i]='b'
        elif W[i]=='q':
            W[i]='p'
        elif W[i]=='p':
            W[i]='q'
    print(f'#{t}', end=" ")
    print(*W, sep="")
