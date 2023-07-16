T=int(input())
for t in range(1,T+1):
    N=int(input())

    L=[2,3,5,7,11]
    AL=[0,0,0,0,0]
    for l in range(len(L)):
        while N%L[l]==0:
            AL[l]+=1
            N=N//L[l]
    print(f'#{t}',end=" ")
    print(*AL)
    