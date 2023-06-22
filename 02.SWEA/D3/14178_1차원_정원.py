T=int(input())
for t in range(1,T+1):
    N,D=map(int,input().split())
    C=(D*2)+1
    R=N//C
    if N%C!=0:
        R+=1
    print(f'#{t} {R}')
