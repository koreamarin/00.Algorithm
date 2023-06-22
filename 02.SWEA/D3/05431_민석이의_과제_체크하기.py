T=int(input())
for t in range(1,T+1):
    N,K= map(int,input().split())
    L=[i+1 for i in range(N)]
    SL=list(map(int,input().split()))
    FL=[]
    for l in L:
        if l not in SL:
            FL.append(l)
    print(f'#{t}',end=" ")
    print(*FL)