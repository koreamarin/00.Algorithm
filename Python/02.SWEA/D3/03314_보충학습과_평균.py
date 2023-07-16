T=int(input())
for t in range(1,T+1):
    L=list(map(int,input().split()))
    for i in range(len(L)):
        if L[i]<40:
            L[i]=40
    print(f'#{t} {sum(L)//5}')