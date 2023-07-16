T=int(input())
for t in range(T):
    N=int(input())
    L=list(map(int,input().split()))
    M=L[-1]
    S=0
    for n in range(N):
        if L[N-1-n] <= M :
            S+=M-L[N-1-n]
        else :
            M=L[N-1-n]
    print(f'#{t+1} {S}')