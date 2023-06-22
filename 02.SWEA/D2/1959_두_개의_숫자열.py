T=int(input())
for t in range(1, T+1):
    N,M=map(int,input().split())
    NL=list(map(int,input().split()))
    ML=list(map(int,input().split()))
    if N<M:
        NL,ML=ML,NL
        N,M = M,N
    L=[]
    for i in range(N-M+1):
        A=0
        for j in range(M):
            A+=NL[j+i]*ML[j]
        L.append(A)
    print(f'#{t} {max(L)}')