T=int(input())
for t in range(1,T+1):
    N=int(input())
    SN=N*N
    P=0
    for x in range(-N,N+1):
        for y in range(-N,N+1):
            if SN>=(x*x)+(y*y):
                P+=1
    print(f'#{t} {P}')
