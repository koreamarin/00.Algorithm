T=int(input())
for t in range(T):
    L=list(map(int,input().split()))
    print(f'#{t+1} {round((sum(L)-max(L)-min(L))/8)}')