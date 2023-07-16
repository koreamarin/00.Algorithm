for _ in range(10):
    t=int(input())
    L=list(map(int,input().split()))
    n=1
    while L[-1]>0:
        L[0]=L[0]-n
        if L[0] < 0:
            L[0]=0
        L.append(L.pop(0))
        n=(n%5)+1
    print(f'#{t}',end=" ")
    print(*L)