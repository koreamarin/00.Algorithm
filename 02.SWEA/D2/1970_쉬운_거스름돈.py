T=int(input())
for t in range(1,T+1):
    D={50000:0, 10000:0, 5000:0, 1000:0, 500:0, 100:0, 50:0, 10:0}
    L=[50000, 10000, 5000, 1000, 500, 100, 50, 10]
    N=int(input())
    for l in L :
        D[l]=N//l
        if N >= l*(N//l) :
            N-=l*(N//l)
    print(f'#{t}')
    print(*D.values())