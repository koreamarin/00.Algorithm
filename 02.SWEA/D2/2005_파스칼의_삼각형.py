T=int(input())
for t in range(1, T+1):
    N=int(input())
    L=[[1]]
    for n in range(1,N):
        A=[1]
        for i in range(1, n):
            A.append(L[n-1][i-1]+L[n-1][i])
        A.append(1)
        L.append(A)
    print(f"#{t}")
    for l in L :
        print(*l)