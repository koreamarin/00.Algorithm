T=int(input())
for t in range(T):
    A = list(map(int,input().split()))
    print(f'#{t+1} {round(sum(A)/10)}')