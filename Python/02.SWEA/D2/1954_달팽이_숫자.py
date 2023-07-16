T=int(input())
for t in range(1,T+1):
    N=int(input())
    L=[[0 for _ in range(N)] for _ in range(N)]

    R='동'
    i=0
    j=0
    k=1
    for _ in range(N*N):
        if L[i][j]==0:
            L[i][j]=k
            k+=1
            if R=='동':
                if j+1 == N or L[i][j+1]!=0:
                    R='남'
                    i+=1
                else :
                    j+=1
            elif R=='남':
                if i+1 == N or L[i+1][j]!=0:
                    R='서'
                    j-=1
                else :
                    i+=1
            elif R=='서':
                if j-1 == -1 or L[i][j-1]!=0:
                    R='북'
                    i-=1
                else :
                    j-=1
            elif R=='북':
                if i-1 == -1 or L[i-1][j]!=0:
                    R='동'
                    j+=1
                else :
                    i-=1
    print(f'#{t}')
    for l in L :
        print(*l)