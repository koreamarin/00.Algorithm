for t in range(1,11):
    N=int(input())
    L=list(map(int,input().split()))
    for n in range(N):
        M=max(L)
        m=min(L)
        L[L.index(M)]-=1
        L[L.index(m)]+=1
    print(f'#{t} {max(L)-min(L)}')