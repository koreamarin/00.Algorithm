T=int(input())
for t in range(1,T+1):
    S=input()
    Win=0
    for s in S:
        if s=='o':
            Win+=1
    P=15-len(S)+Win
    print(f'#{t} YES' if P>=8 else f'#{t} NO')