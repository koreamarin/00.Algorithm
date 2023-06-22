T=int(input())
for t in range(1, T+1):
    int(input())
    print(f'#{t}',end=" ")
    print(*sorted(list(map(int,input().split()))), sep=" ")