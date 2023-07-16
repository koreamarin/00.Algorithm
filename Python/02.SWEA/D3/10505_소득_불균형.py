T=int(input())
for t in range(1,T+1):
    N=int(input())
    L=list(map(int,input().split()))
    avg=sum(L)/N
    R=0
    for l in L :
        if l<=avg:
            R+=1
    print(f'#{t} {R}')