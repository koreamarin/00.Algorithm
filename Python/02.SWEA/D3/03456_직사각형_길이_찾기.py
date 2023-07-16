T=int(input())
for t in range(1,T+1):
    A,B,C=map(int,input().split())
    D=0
    if A==B==C:
        D=A
    elif A==B:
        D=C
    elif A==C:
        D=B
    elif B==C:
        D=A
    print(f'#{t} {D}')