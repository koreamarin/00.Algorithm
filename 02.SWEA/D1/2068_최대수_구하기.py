T=int(input())
for t in range(T):
    print(f'#{t+1} {max(list(map(int, input().split())))}')