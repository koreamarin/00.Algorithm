T=int(input())
for t in range(1, T+1):
    N=int(input())
    L=[list(map(int,input().split())) for _ in range(N)]
    R_90 = [[L[j][i] for j in range(N-1,-1,-1)] for i in range(N)]
    R_180 = [[L[i][j] for j in range(N-1,-1,-1)] for i in range(N-1,-1,-1)]
    R_270 = [[L[j][i] for j in range(N)] for i in range(N-1,-1,-1)]

    print(f'#{t}')
    for i in range(N):
        for j in range(N):
            print(R_90[i][j], end="")
        print("",end = " ")
        for j in range(N):
            print(R_180[i][j], end="")
        print("",end = " ")
        for j in range(N):
            print(R_270[i][j], end="")
        print()