T=int(input())
for t in range(1,T+1):
    N=int(input())
    S,D=0,0
    for n in range(N):
        C=list(map(int,input().split()))
        if C[0]==1:
            S=S+C[1]
        elif C[0]==2:
            if S>0:
                S=S-C[1]
            elif S==0:
                S=0
        D+=S
    print(f'#{t} {D}')