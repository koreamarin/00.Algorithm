T=int(input())
for t in range(1,T+1):
    N=int(input())
    L=['0','1','2','3','4','5','6','7','8','9']
    M=0
    while len(L)!=0:
        M+=1
        A=str(N*M)
        for a in A:
            if a in L:
                L.remove(a)
    print(f'#{t} {N*M}')