T=int(input())

for t in range(1, T+1):
    N=int(input())
    S=0
    for n in range(1, N+1):
        if n % 2 == 1:
            S+=n
        elif n % 2 == 0:
            S-=n

    print(f'#{t} {S}')