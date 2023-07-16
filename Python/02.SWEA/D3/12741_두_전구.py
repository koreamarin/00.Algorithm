T=int(input())
O=[]
for t in range(1,T+1):
    A,B,C,D=map(int,input().split())
    X=[i for i in range(A,B)]
    Y=[i for i in range(C,D)]
    L=list(set(X)&set(Y))
    O.append(f'#{t} {len(L)}')
print(*O, sep="\n")